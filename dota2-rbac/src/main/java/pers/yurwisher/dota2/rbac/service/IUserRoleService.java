package pers.yurwisher.dota2.rbac.service;

import pers.yurwisher.dota2.common.base.BaseService;
import pers.yurwisher.dota2.rbac.entity.UserRole;

import java.util.List;

/**
 * <p>
 * 用户角色关联表 服务类
 * </p>
 *
 * @author yq
 * @since 2019-07-10
 */
public interface IUserRoleService extends BaseService<UserRole> {

    /**
     * 绑定角色
     * @param userId 用户id
     * @param roleIds 角色id集合
     */
    void bindRole(Long userId, List<Long> roleIds);

    /**
     * 给用户添加角色
     * @param userId 用户ID
     * @param roleId 角色ID
     */
    void addRole(Long userId,Long roleId);
}
