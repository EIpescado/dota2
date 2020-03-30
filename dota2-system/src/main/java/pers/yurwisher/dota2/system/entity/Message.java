package pers.yurwisher.dota2.system.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.yurwisher.dota2.common.base.BaseEntity;
import pers.yurwisher.dota2.common.enums.MessageStatusEnum;
import pers.yurwisher.dota2.common.enums.MessageTypeEnum;

/**
 * @author yq
 * @date 2019/08/15 16:13
 * @description 消息
 * @since V1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Message extends BaseEntity {

    /**
     * 消息内容表ID
     */
    private Long messageId;
    /**
     * 接收人用户ID
     */
    private Long receiverId;
    /**
     * 发送人用户ID
     */
    private Long senderId;
    /**
     * 消息状态
     */
    private MessageStatusEnum status;

    /**
     * 查询标识,由receiver_id 和 sender_id组合而成,按字典排序
     */
    private String queryId;

    /**
     * 消息类型
     */
    private MessageTypeEnum type;
}
