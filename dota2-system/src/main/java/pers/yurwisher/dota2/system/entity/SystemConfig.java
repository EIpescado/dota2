package pers.yurwisher.dota2.system.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.yurwisher.dota2.common.base.BaseEntity;

/**
 * <p>
 * 系统配置
 * </p>
 *
 * @author yq
 * @since 2018-12-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SystemConfig extends BaseEntity {

    /**
     * 配置名称
     */
    private String name;

    /**
     * 配置编码
     */
    private String code;

    /**
     * 配置值
     */
    private String val;


}
