package pers.yurwisher.dota2.system.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.yurwisher.dota2.common.base.impl.BaseServiceImpl;
import pers.yurwisher.dota2.common.constant.SystemConstant;
import pers.yurwisher.dota2.common.enums.MessageStatusEnum;
import pers.yurwisher.dota2.common.enums.MessageTypeEnum;
import pers.yurwisher.dota2.common.utils.Utils;
import pers.yurwisher.dota2.common.wrapper.JWTUser;
import pers.yurwisher.dota2.system.entity.Message;
import pers.yurwisher.dota2.system.entity.MessageContent;
import pers.yurwisher.dota2.system.mapper.MessageContentMapper;
import pers.yurwisher.dota2.system.mapper.MessageMapper;
import pers.yurwisher.dota2.system.pojo.cache.MessageTemplateCache;
import pers.yurwisher.dota2.system.pojo.fo.NoticeFo;
import pers.yurwisher.dota2.system.pojo.fo.SystemMessageFo;
import pers.yurwisher.dota2.system.pojo.fo.WebMessageFo;
import pers.yurwisher.dota2.system.pojo.qo.MessageQo;
import pers.yurwisher.dota2.system.pojo.to.MessageTo;
import pers.yurwisher.dota2.system.pojo.vo.MessageVo;
import pers.yurwisher.dota2.system.pojo.vo.UnReadMessage;
import pers.yurwisher.dota2.system.service.IMessageService;
import pers.yurwisher.dota2.system.service.IMessageTemplateService;
import pers.yurwisher.wisp.utils.Asserts;
import pers.yurwisher.wisp.wrapper.PageR;

/**
 * @author yq
 * @date 2019-08-15 17:07:13
 * @description 消息
 * @since V1.0.0
 */
@Service
public class MessageServiceImpl extends BaseServiceImpl<MessageMapper, Message> implements IMessageService {

    private MessageContentMapper messageContentMapper;
    private IMessageTemplateService messageTemplateService;

    public MessageServiceImpl(MessageContentMapper messageContentMapper, IMessageTemplateService messageTemplateService) {
        this.messageContentMapper = messageContentMapper;
        this.messageTemplateService = messageTemplateService;
    }

    @Override
    @SuppressWarnings("unchecked")
    public PageR<MessageTo> webList(MessageQo qo) {
        //接收人用户ID
        Long currentId = JWTUser.currentUserId();
        String queryId = Utils.getQueryId(currentId, qo.getTalkUserId());
        return super.toPageR(baseMapper.webList(super.toPage(qo), queryId, currentId, MessageTypeEnum.WEB));
    }

    @Override
    @SuppressWarnings("unchecked")
    public PageR<MessageTo> systemList(MessageQo qo) {
        return super.toPageR(baseMapper.systemList(super.toPage(qo), JWTUser.current().getId(), MessageTypeEnum.SYSTEM));
    }

    @Override
    @SuppressWarnings("unchecked")
    public PageR<MessageTo> noticeList(MessageQo qo) {
        return super.toPageR(messageContentMapper.noticeList(super.toPage(qo), qo, MessageTypeEnum.NOTICE));
    }

    @Override
    public UnReadMessage unReadSummarize() {
        Long receiverId = JWTUser.currentUserId();
        //未读web消息
        Integer web = baseMapper.countByReceiverIdAndTypeAndStatus(receiverId, MessageTypeEnum.WEB, MessageStatusEnum.UN_READ);
        //未读system消息
        Integer system = baseMapper.countByReceiverIdAndTypeAndStatus(receiverId, MessageTypeEnum.SYSTEM, MessageStatusEnum.UN_READ);
        return new UnReadMessage(web, system);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createNotice(NoticeFo fo) {
        this.createMessageContent(MessageTypeEnum.NOTICE, fo.getTitle(), fo.getContent(),null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateNotice(Long id, NoticeFo fo) {
        MessageContent content = messageContentMapper.selectById(id);
        Asserts.notNull(content);
        content.setTitle(fo.getTitle());
        content.setContent(fo.getContent());
        messageContentMapper.updateById(content);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void pushSystemMessage(SystemMessageFo fo) {
        //获取对应消息模版
        MessageTemplateCache cache = messageTemplateService.getTemplateByTypeAndCode(fo.getMessageTemplateType(), fo.getTemplateCode());
        Asserts.notNull(cache);
        String title = cache.getTemplateName();
        String content;
        MessageContent messageContent;
        if (cache.getWhetherNeedFormat()) {
            content = Utils.format(cache.getTemplate(), fo.getParams());
            //需要格式化时 根据模版消息创建新的消息
            messageContent = this.createMessageContent(MessageTypeEnum.SYSTEM, title, content,cache.getId());
        } else {
            content = cache.getTemplate();
            //不需要格式化 即表示内容固定 先查询是否已经存在记录
            messageContent = messageContentMapper.findByTemplateIdAndDateCreatedGe(MessageTypeEnum.SYSTEM,cache.getId(),cache.getLastUpdated());
            if(messageContent == null){
                messageContent = this.createMessageContent(MessageTypeEnum.SYSTEM, title, content,cache.getId());
            }
        }
        //关联到当前用户
        relateToUser(messageContent, fo.getReceiverId(), SystemConstant.ADMIN_USER_ID);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void pushWebMessage(WebMessageFo fo) {
        MessageContent messageContent = this.createMessageContent(MessageTypeEnum.WEB, "", fo.getContent(),null);
        //关联到当前用户
        relateToUser(messageContent, fo.getReceiverId(), JWTUser.currentUserId());
    }

    @Override
    public MessageVo getNoticeDetail(Long id) {
        return messageContentMapper.getNoticeDetail(id,MessageTypeEnum.NOTICE);
    }

    private MessageContent createMessageContent(MessageTypeEnum messageType, String title, String content,Long templateId) {
        MessageContent messageContent = new MessageContent();
        messageContent.setTitle(title);
        messageContent.setContent(content);
        messageContent.setType(messageType);
        messageContent.setTemplateId(templateId);
        messageContentMapper.insert(messageContent);
        return messageContent;
    }

    /**
     * 消息关联到用户
     *
     * @param message    消息
     * @param receiverId 接收人
     * @param senderId   发送人
     */
    private void relateToUser(MessageContent message, Long receiverId, Long senderId) {
        //关联到用户
        Message relation = new Message();
        relation.setReceiverId(receiverId);
        relation.setStatus(MessageStatusEnum.UN_READ);
        relation.setType(message.getType());
        relation.setMessageId(message.getId());
        relation.setSenderId(senderId);
        relation.setQueryId(Utils.getQueryId(receiverId, senderId));
        baseMapper.insert(relation);
    }

}
