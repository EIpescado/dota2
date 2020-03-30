package pers.yurwisher.dota2.rbac.pojo.qo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.yurwisher.dota2.common.wrapper.PageQo;

/**
 * @author yq
 * @date 2019-07-11 16:38:43
 * @description 角色 Qo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SystemRoleQo extends PageQo {
    private static final long serialVersionUID = 6756597616847264685L;
    private String roleName;
    private String roleCode;
    private String description;
}
