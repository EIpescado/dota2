package pers.yurwisher.dota2.system.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.yurwisher.dota2.common.base.impl.BaseServiceImpl;
import pers.yurwisher.dota2.common.constant.cache.SystemCacheConstant;
import pers.yurwisher.dota2.system.entity.MessageTemplate;
import pers.yurwisher.dota2.system.mapper.MessageTemplateMapper;
import pers.yurwisher.dota2.system.pojo.cache.MessageTemplateCache;
import pers.yurwisher.dota2.system.pojo.fo.MessageTemplateFo;
import pers.yurwisher.dota2.system.pojo.qo.MessageTemplateQo;
import pers.yurwisher.dota2.system.pojo.to.MessageTemplateTo;
import pers.yurwisher.dota2.system.pojo.vo.MessageTemplateVo;
import pers.yurwisher.dota2.system.service.IMessageTemplateService;
import pers.yurwisher.wisp.utils.Asserts;
import pers.yurwisher.wisp.wrapper.PageR;

/**
 * @author yq
 * @date 2019-08-23 10:23:01
 * @description 消息模版
 * @since V1.0.0
 */
@Service
public class MessageTemplateServiceImpl extends BaseServiceImpl<MessageTemplateMapper,MessageTemplate> implements IMessageTemplateService{

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(MessageTemplateFo fo){
        MessageTemplate messageTemplate = new MessageTemplate();
        BeanUtils.copyProperties(fo,messageTemplate);
        baseMapper.insert(messageTemplate);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = SystemCacheConstant.MESSAGE_TEMPLATE_TYPE_CODE_MESSAGE_TEMPLATE,key = "#fo.type + '_' + #fo.code")
    public void update(Long id,MessageTemplateFo fo){
        MessageTemplate messageTemplate = baseMapper.selectById(id);
        Asserts.notNull(messageTemplate);
        BeanUtils.copyProperties(fo,messageTemplate);
        baseMapper.updateById(messageTemplate);
    }

    @Override
    public MessageTemplateVo get(Long id) {
        return baseMapper.get(id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public PageR<MessageTemplateTo> list(MessageTemplateQo qo){
        return super.toPageR(baseMapper.list(super.toPage(qo),qo));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = SystemCacheConstant.MESSAGE_TEMPLATE_TYPE_CODE_MESSAGE_TEMPLATE)
    public void delete(Long id){
        baseMapper.deleteById(id);
    }

    @Override
    @Cacheable(value = SystemCacheConstant.MESSAGE_TEMPLATE_TYPE_CODE_MESSAGE_TEMPLATE,key = "#type + '_' + #code",unless = "#result == null")
    public MessageTemplateCache getTemplateByTypeAndCode(String type, String code){
        return baseMapper.getTemplateByTypeAndCode(type,code);
    }

}
