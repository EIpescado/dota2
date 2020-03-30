package pers.yurwisher.dota2.rbac.mapper;

import org.apache.ibatis.annotations.Param;
import pers.yurwisher.dota2.common.base.CommonMapper;
import pers.yurwisher.dota2.rbac.entity.Permission;
import pers.yurwisher.dota2.rbac.pojo.dto.PermissionNode;
import pers.yurwisher.dota2.rbac.pojo.vo.PermissionVo;

import java.util.List;

/**
 * @author yq
 * @date 2019-10-08 14:52:14
 * @description 权限 Mapper
 * @since V1.0.0
 */
public interface PermissionMapper extends CommonMapper<Permission> {

    List<PermissionNode> findAllByRoleId(@Param("roleId")Long roleId);

    List<PermissionNode> findAllPermission();

    PermissionVo get(@Param("id") Long id);
}
