package pers.yurwisher.dota2.system.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import pers.yurwisher.dota2.common.enums.MessageTypeEnum;

import java.time.LocalDateTime;

/**
 * @author yq
 * @date 2019/08/15 16:13
 * @description 消息详情
 * @since V1.0.0
 */
@Data
public class MessageContent{

    /**
     * 消息类型枚举
     */
    private MessageTypeEnum type;
    /**
     * 消息标题
     */
    private String title;
    /**
     * 消息内容
     */
    private String content;

    /**
     * 模版ID,系统消息此字段才有值
     */
    private Long templateId;

    @TableId
    private Long id;

    /**
     * 启用,禁用
     */
    @TableLogic
    private Boolean enabled;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime dateCreated;
}
