package pers.yurwisher.dota2.rbac.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import pers.yurwisher.dota2.common.base.BaseEntity;

import java.time.LocalDateTime;

/**
 * <p>
 * 职位
 * </p>
 *
 * @author yq
 * @since 2019-07-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Job extends BaseEntity {
    /**
     * 职位名称
     */
    private String name;
    /**
     * 所属部门
     */
    private Long departmentId;

    private Integer rowNo;
}
