package pers.yurwisher.dota2.rbac.service;

import pers.yurwisher.dota2.common.base.BaseService;
import pers.yurwisher.dota2.rbac.entity.RolePermission;

import java.util.List;


/**
 * @author yq
 * @date 2019-10-08 15:11:03
 * @description 角色权限关联
 * @since V1.0.0
 */
public interface IRolePermissionService extends BaseService<RolePermission> {

    /**
     * 角色绑定权限
     * @param roleId 角色ID
     * @param permissionIds 权限ID
     */
    void bind(Long roleId, List<Long> permissionIds);
}
