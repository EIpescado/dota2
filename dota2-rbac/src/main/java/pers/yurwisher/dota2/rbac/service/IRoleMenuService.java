package pers.yurwisher.dota2.rbac.service;

import pers.yurwisher.dota2.common.base.BaseService;
import pers.yurwisher.dota2.rbac.entity.RoleMenu;

import java.util.List;

/**
 * <p>
 * 角色菜单关联表 服务类
 * </p>
 *
 * @author yq
 * @since 2019-07-10
 */
public interface IRoleMenuService extends BaseService<RoleMenu> {

    /**
     * 角色绑定菜单
     * @param roleId 角色ID
     * @param menuIds 菜单id集合
     */
    void bind(Long roleId, List<Long> menuIds);
}
