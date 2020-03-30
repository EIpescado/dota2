package pers.yurwisher.dota2.system.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.yurwisher.dota2.common.base.BaseEntity;

/**
 * @author yq
 * @date 2019/10/31 09:14
 * @description 企业门户信息配置
 * @since V1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class EnterprisePortalInfo extends BaseEntity {

    /**json值*/
    private String content;
    /**
     * 是否已激活
     */
    private Boolean activated;

    private String remark;
}
