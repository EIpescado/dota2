package pers.yurwisher.dota2.system.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.yurwisher.dota2.common.base.BaseEntity;

/**
 * @author yq
 * @date 2019/08/23 10:19
 * @description 消息模版
 * @since V1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MessageTemplate extends BaseEntity {

    /**
     * 模版编码
     */
    private String code;
    /**
     * 模版名称
     */
    private String name;
    /**
     * 消息模版类别
     */
    private String type;
    /**
     * 模版
     */
    private String template;

    /**
     * 是否需要格式化
     */
    private Boolean whetherNeedFormat;
}
