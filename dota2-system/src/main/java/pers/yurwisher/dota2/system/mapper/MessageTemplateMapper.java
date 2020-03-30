package pers.yurwisher.dota2.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import pers.yurwisher.dota2.common.base.CommonMapper;
import pers.yurwisher.dota2.system.entity.MessageTemplate;
import pers.yurwisher.dota2.system.pojo.cache.MessageTemplateCache;
import pers.yurwisher.dota2.system.pojo.qo.MessageTemplateQo;
import pers.yurwisher.dota2.system.pojo.to.MessageTemplateTo;
import pers.yurwisher.dota2.system.pojo.vo.MessageTemplateVo;

/**
 * @author yq
 * @date 2019-08-23 10:23:01
 * @description 消息模版 Mapper
 * @since V1.0.0
 */
public interface MessageTemplateMapper extends CommonMapper<MessageTemplate> {

    /**
     * 列表
     * @param page mybatis-plus分页参数
     * @param qo 查询参数
     * @return 列表
     */
    IPage<MessageTemplateTo> list(Page page, @Param("qo") MessageTemplateQo qo);

    /**
     * 详情
     * @param id 主键
     * @return 详情
     */
    MessageTemplateVo get(@Param("id") Long id);

    /**
     * 根据类型 和 编码获取模版
     * @param type 类型
     * @param code 编码
     * @return 模版
     */
    MessageTemplateCache getTemplateByTypeAndCode(@Param("type") String type, @Param("code") String code);
}
