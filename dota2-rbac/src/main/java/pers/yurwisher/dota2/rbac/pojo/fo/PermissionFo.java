package pers.yurwisher.dota2.rbac.pojo.fo;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * @author yq
 * @date 2019-10-08 14:52:14
 * @description 权限 Fo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PermissionFo implements Serializable {
    private static final long serialVersionUID = -6044380975264985638L;
    private String permissionName;
    private String permissionCode;
    private Long parentId;
}
