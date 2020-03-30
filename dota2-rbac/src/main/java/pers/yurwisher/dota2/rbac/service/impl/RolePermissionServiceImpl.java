package pers.yurwisher.dota2.rbac.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.yurwisher.dota2.common.base.impl.BaseServiceImpl;
import pers.yurwisher.dota2.rbac.entity.RolePermission;
import pers.yurwisher.dota2.rbac.mapper.RolePermissionMapper;
import pers.yurwisher.dota2.rbac.service.IRolePermissionService;
import pers.yurwisher.wisp.utils.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yq
 * @date 2019-10-08 15:11:03
 * @description 角色权限关联
 * @since V1.0.0
 */
@Service
public class RolePermissionServiceImpl extends BaseServiceImpl<RolePermissionMapper, RolePermission> implements IRolePermissionService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void bind(Long roleId, List<Long> permissionIds) {
        if (CollectionUtils.isNotEmpty(permissionIds)) {
            //删除之前
            baseMapper.deleteByRoleId(roleId);
            //绑定
            List<RolePermission> rolePermissionList = permissionIds.stream().map(mid -> {
                RolePermission relation = new RolePermission();
                relation.setRoleId(roleId);
                relation.setPermissionId(mid);
                return relation;
            }).collect(Collectors.toList());
            super.saveBatch(rolePermissionList);
        }
    }
}
