package pers.yurwisher.dota2.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import pers.yurwisher.dota2.common.base.CommonMapper;
import pers.yurwisher.dota2.common.enums.MessageStatusEnum;
import pers.yurwisher.dota2.common.enums.MessageTypeEnum;
import pers.yurwisher.dota2.system.entity.Message;
import pers.yurwisher.dota2.system.pojo.to.MessageTo;

/**
 * @author yq
 * @date 2019-08-15 17:07:13
 * @description 消息 Mapper
 * @since V1.0.0
 */
public interface MessageMapper extends CommonMapper<Message> {

    /**
     * 站内信列表 用户与用户之间
     * @param page mybatis-plus分页参数
     * @param queryId 查询标识
     * @param currentId 当前用户ID,即要查询聊天记录的用户ID
     * @param messageType 消息类型
     * @return 列表
     */
    IPage<MessageTo> webList(Page page, @Param("queryId") String queryId,
                             @Param("currentId") Long currentId,
                             @Param("messageType") MessageTypeEnum messageType);

    /**
     *  系统通知 ,系统单方面发给指定用户的消息
     * @param page 分页参数
     * @param receiverId 接收人ID
     * @param messageType 消息类型
     * @return 系统通知
     */
    IPage<MessageTo> systemList(Page page, @Param("receiverId") Long receiverId, @Param("messageType") MessageTypeEnum messageType);

    /**
     * 根据接受人,消息类型,消息状态合计数量
     * @param receiverId 接收人ID
     * @param messageType 消息类型
     * @param messageStatus 消息状态
     * @return 数量
     */
    Integer countByReceiverIdAndTypeAndStatus(@Param("receiverId") Long receiverId,
                                              @Param("messageType") MessageTypeEnum messageType,
                                              @Param("messageStatus") MessageStatusEnum messageStatus);
}
