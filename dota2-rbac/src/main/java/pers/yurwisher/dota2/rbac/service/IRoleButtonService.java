package pers.yurwisher.dota2.rbac.service;

import pers.yurwisher.dota2.common.base.BaseService;
import pers.yurwisher.dota2.rbac.entity.RoleButton;

import java.util.List;

/**
 * <p>
 * 角色按钮关联表 服务类
 * </p>
 *
 * @author yq
 * @since 2019-07-10
 */
public interface IRoleButtonService extends BaseService<RoleButton> {

    /**
     * 角色绑定按钮
     * @param roleId 角色id
     * @param buttonIds 按钮集合
     */
    void bind(Long roleId, List<Long> buttonIds);
}
