package pers.yurwisher.dota2.rbac.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.yurwisher.dota2.common.base.impl.BaseServiceImpl;
import pers.yurwisher.dota2.rbac.entity.UserRole;
import pers.yurwisher.dota2.rbac.mapper.UserRoleMapper;
import pers.yurwisher.dota2.rbac.service.IUserRoleService;
import pers.yurwisher.wisp.utils.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author yq
 * @since 2019-07-10
 */
@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void bindRole(Long userId, List<Long> roleIds) {
        if(CollectionUtils.isNotEmpty(roleIds)){
           //删除之前绑定的角色
           baseMapper.deleteByUserId(userId);
           List<UserRole> userRoleList =  roleIds.stream().map(rid -> {
                UserRole userRole = new UserRole();
                userRole.setRoleId(rid);
                userRole.setUserId(userId);
                return userRole;
            }).collect(Collectors.toList());
           super.saveBatch(userRoleList);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addRole(Long userId, Long roleId) {
        if(roleId != null && userId != null){
            UserRole userRole = new UserRole();
            userRole.setRoleId(roleId);
            userRole.setUserId(userId);
            baseMapper.insert(userRole);
        }
    }

}
