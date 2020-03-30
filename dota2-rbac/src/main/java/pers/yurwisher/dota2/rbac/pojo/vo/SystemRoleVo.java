package pers.yurwisher.dota2.rbac.pojo.vo;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * @author yq
 * @date 2019-07-11 16:38:43
 * @description 角色 Vo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SystemRoleVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String roleName;
    private String roleCode;
    private String description;
    private Boolean enabled;
    private Integer rank;
}
