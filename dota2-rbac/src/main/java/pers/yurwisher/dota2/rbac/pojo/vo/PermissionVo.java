package pers.yurwisher.dota2.rbac.pojo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author yq
 * @date 2019-10-08 14:52:14
 * @description 权限 VO
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PermissionVo implements Serializable {
    private static final long serialVersionUID = -8646732367425393914L;
    private String permissionName;
    private String permissionCode;
    private Long parentId;
}
