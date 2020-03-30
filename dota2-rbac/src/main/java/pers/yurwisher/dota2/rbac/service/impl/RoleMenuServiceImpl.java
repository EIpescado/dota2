package pers.yurwisher.dota2.rbac.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.yurwisher.dota2.common.base.impl.BaseServiceImpl;
import pers.yurwisher.dota2.rbac.entity.RoleMenu;
import pers.yurwisher.dota2.rbac.mapper.RoleMenuMapper;
import pers.yurwisher.dota2.rbac.service.IRoleMenuService;
import pers.yurwisher.wisp.utils.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色菜单关联表 服务实现类
 * </p>
 *
 * @author yq
 * @since 2019-07-10
 */
@Service
public class RoleMenuServiceImpl extends BaseServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void bind(Long roleId, List<Long> menuIds) {
        if(CollectionUtils.isNotEmpty(menuIds)){
            //删除之前
            baseMapper.deleteByRoleId(roleId);
            //绑定
            List<RoleMenu> userRoleList =  menuIds.stream().map(mid -> {
                RoleMenu relation = new RoleMenu();
                relation.setRoleId(roleId);
                relation.setMenuId(mid);
                return relation;
            }).collect(Collectors.toList());
            super.saveBatch(userRoleList);
        }
    }
}
