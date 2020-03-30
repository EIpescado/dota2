package pers.yurwisher.dota2.system.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.yurwisher.dota2.common.base.BaseEntity;

import java.time.LocalDateTime;

/**
 * @author yq
 * @date 2019/11/11 22:26
 * @description 状态日志
 * @since V1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class StatusLog extends BaseEntity {

    /**操作人*/
    private Long operatorId;
    /**状态变更时间*/
    private LocalDateTime changeDate;
    /**备注*/
    private String remark;
    /**状态*/
    private String status;
    /**关联实体ID*/
    private Long entityId;
    /**状态*/
    private String entityClassName;
}
