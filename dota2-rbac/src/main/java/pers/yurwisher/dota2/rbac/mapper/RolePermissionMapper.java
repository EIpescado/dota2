package pers.yurwisher.dota2.rbac.mapper;

import pers.yurwisher.dota2.common.base.CommonMapper;
import pers.yurwisher.dota2.rbac.entity.RolePermission;
import org.apache.ibatis.annotations.Param;

/**
 * @author yq
 * @date 2019-10-08 15:11:03
 * @description 角色权限关联 Mapper
 * @since V1.0.0
 */
public interface RolePermissionMapper extends CommonMapper<RolePermission> {

    /**
     * 感觉角色ID删除绑定关系
     * @param roleId 角色ID
     */
    void deleteByRoleId(@Param("roleId") Long roleId);
}
