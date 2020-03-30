package pers.yurwisher.dota2.system.pojo.qo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.yurwisher.dota2.common.wrapper.PageQo;

/**
 * @author yq
 * @date 2019/10/31 11:27
 * @description 企业门户配置
 * @since V1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class EnterprisePortalInfoQo extends PageQo {
    private static final long serialVersionUID = 1292705357704963965L;

    private String remark;
}
