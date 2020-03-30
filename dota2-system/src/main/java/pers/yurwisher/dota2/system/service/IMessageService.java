package pers.yurwisher.dota2.system.service;

import pers.yurwisher.dota2.common.base.BaseService;
import pers.yurwisher.dota2.system.entity.Message;
import pers.yurwisher.dota2.system.pojo.fo.NoticeFo;
import pers.yurwisher.dota2.system.pojo.fo.SystemMessageFo;
import pers.yurwisher.dota2.system.pojo.fo.WebMessageFo;
import pers.yurwisher.dota2.system.pojo.qo.MessageQo;
import pers.yurwisher.dota2.system.pojo.to.MessageTo;
import pers.yurwisher.dota2.system.pojo.vo.MessageVo;
import pers.yurwisher.dota2.system.pojo.vo.UnReadMessage;
import pers.yurwisher.wisp.wrapper.PageR;


/**
 * @author yq
 * @date 2019-08-15 17:07:13
 * @description 消息
 * @since V1.0.0
 */
public interface IMessageService extends BaseService<Message> {

    /**
     * 站内信列表,用户与用户之间
     * @param qo 查询参数
     * @return 分页对象
     */
    PageR<MessageTo> webList(MessageQo qo);

    /**
     * 系统消息列表,即系统推送给单个用户的提示信息
     * @param qo 查询参数
     * @return 分页对象
     */
    PageR<MessageTo> systemList(MessageQo qo);

    /**
     * 系统公告
     * @param qo 查询参数
     * @return 分页对象
     */
    PageR<MessageTo> noticeList(MessageQo qo);

    /**
     * 未读消息汇总
     * @return 汇总结果
     */
    UnReadMessage unReadSummarize();

    /**
     * 创建公告
     * @param fo 公告详情
     */
    void createNotice(NoticeFo fo);

    /**
     * 更新
     * @param id 主键
     * @param fo 参数
     */
    void updateNotice(Long id, NoticeFo fo);

    /**
     * 推送系统消息
     * @param fo
     */
    void pushSystemMessage(SystemMessageFo fo);

    /**
     * 用户站内私信
     * @param fo
     */
    void pushWebMessage(WebMessageFo fo);

    /**
     * 公告详情
     * @param id 公告ID
     * @return 详情
     */
    MessageVo getNoticeDetail(Long id);
}
