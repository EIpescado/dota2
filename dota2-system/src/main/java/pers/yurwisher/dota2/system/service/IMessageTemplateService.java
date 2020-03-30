package pers.yurwisher.dota2.system.service;

import pers.yurwisher.dota2.common.base.BaseService;
import pers.yurwisher.dota2.system.entity.MessageTemplate;
import pers.yurwisher.dota2.system.pojo.cache.MessageTemplateCache;
import pers.yurwisher.dota2.system.pojo.fo.MessageTemplateFo;
import pers.yurwisher.dota2.system.pojo.qo.MessageTemplateQo;
import pers.yurwisher.dota2.system.pojo.to.MessageTemplateTo;
import pers.yurwisher.dota2.system.pojo.vo.MessageTemplateVo;
import pers.yurwisher.wisp.wrapper.PageR;


/**
 * @author yq
 * @date 2019-08-23 10:23:01
 * @description 消息模版
 * @since V1.0.0
 */
public interface IMessageTemplateService extends BaseService<MessageTemplate> {

    /**
     * 新增
     * @param fo 参数
     */
    void create(MessageTemplateFo fo);

    /**
     * 更新
     * @param id 主键
     * @param fo 参数
     */
    void update(Long id, MessageTemplateFo fo);

    /**
     * 详情
     * @param id 主键
     * @return 详情
     */
    MessageTemplateVo get(Long id);

    /**
     * 列表
     * @param qo 查询参数
     * @return 分页对象
     */
    PageR<MessageTemplateTo> list(MessageTemplateQo qo);

     /**
     * 删除
     * @param id 主键
     */
    void delete(Long id);

    /**
     * 根据分类 和 编码获取消息模版 并存入缓存
     * @param type 消息分类 字典表中定义
     * @param code 消息编码
     * @return 消息模版
     */
    MessageTemplateCache getTemplateByTypeAndCode(String type, String code);

}
