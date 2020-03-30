package pers.yurwisher.dota2.rbac.pojo.fo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
/**
 * @author yq
 * @date 2019-07-11 16:38:43
 * @description 角色 Fo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SystemRoleFo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String roleName;
    private String roleCode;
    private String description;
}
