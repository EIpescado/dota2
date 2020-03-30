package pers.yurwisher.dota2.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import pers.yurwisher.dota2.common.base.CommonMapper;
import pers.yurwisher.dota2.common.enums.MessageTypeEnum;
import pers.yurwisher.dota2.system.entity.MessageContent;
import pers.yurwisher.dota2.system.pojo.qo.MessageQo;
import pers.yurwisher.dota2.system.pojo.to.MessageTo;
import pers.yurwisher.dota2.system.pojo.vo.MessageVo;

import java.time.LocalDateTime;

/**
 * @author yq
 * @date 2019-08-15 17:10:44
 * @description 消息 Mapper
 * @since V1.0.0
 */
public interface MessageContentMapper extends CommonMapper<MessageContent> {

    /**
     * 系统公告列表
     *
     * @param page        mybatis-plus分页参数
     * @param qo          查询参数
     * @param messageType 消息类型
     * @return 列表
     */
    IPage<MessageTo> noticeList(Page page, @Param("qo") MessageQo qo, @Param("messageType") MessageTypeEnum messageType);

    /**
     * 获取使用指定模版创建的消息id
     * @param messageType 消息类型
     * @param templateId  模版ID
     * @param templateLastUpdated 模版最后修改时间
     * @return
     */
    MessageContent findByTemplateIdAndDateCreatedGe(@Param("messageType") MessageTypeEnum messageType,
                                                    @Param("templateId") Long templateId,
                                                    @Param("templateLastUpdated") LocalDateTime templateLastUpdated);

    /**
     * 获取公告详情
     * @param id id
     * @param messageType 消息类型
     * @return 公告详情
     */
    MessageVo getNoticeDetail(@Param("id") Long id, @Param("messageType") MessageTypeEnum messageType);
}
