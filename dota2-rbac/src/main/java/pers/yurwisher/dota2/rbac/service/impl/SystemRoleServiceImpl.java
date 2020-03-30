package pers.yurwisher.dota2.rbac.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.yurwisher.dota2.common.base.impl.BaseServiceImpl;
import pers.yurwisher.dota2.common.constant.cache.RBACCacheConstant;
import pers.yurwisher.dota2.common.enums.ComponentTypeEnum;
import pers.yurwisher.dota2.rbac.entity.SystemRole;
import pers.yurwisher.dota2.rbac.mapper.SystemRoleMapper;
import pers.yurwisher.dota2.rbac.pojo.dto.TreeNode;
import pers.yurwisher.dota2.rbac.pojo.fo.SystemRoleFo;
import pers.yurwisher.dota2.rbac.pojo.qo.SystemRoleQo;
import pers.yurwisher.dota2.rbac.pojo.to.SystemRoleTo;
import pers.yurwisher.dota2.rbac.pojo.vo.SystemRoleVo;
import pers.yurwisher.dota2.rbac.service.IButtonService;
import pers.yurwisher.dota2.rbac.service.IMenuService;
import pers.yurwisher.dota2.rbac.service.IRoleButtonService;
import pers.yurwisher.dota2.rbac.service.IRoleMenuService;
import pers.yurwisher.dota2.rbac.service.IRolePermissionService;
import pers.yurwisher.dota2.rbac.service.ISystemRoleService;
import pers.yurwisher.wisp.utils.Asserts;
import pers.yurwisher.wisp.utils.CollectionUtils;
import pers.yurwisher.wisp.wrapper.PageR;
import pers.yurwisher.wisp.wrapper.So;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yq
 * @date 2019-07-11 16:38:43
 * @description 角色
 * @since V1.0.0
 */
@Service
public class SystemRoleServiceImpl extends BaseServiceImpl<SystemRoleMapper, SystemRole> implements ISystemRoleService {

    private IMenuService menuService;
    private IButtonService buttonService;
    private IRoleMenuService roleMenuService;
    private IRoleButtonService roleButtonService;
    private IRolePermissionService rolePermissionService;

    public SystemRoleServiceImpl(IMenuService menuService, IButtonService buttonService, IRoleMenuService roleMenuService, IRoleButtonService roleButtonService, IRolePermissionService rolePermissionService) {
        this.menuService = menuService;
        this.buttonService = buttonService;
        this.roleMenuService = roleMenuService;
        this.roleButtonService = roleButtonService;
        this.rolePermissionService = rolePermissionService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = RBACCacheConstant.SELECT,key = "T(pers.yurwisher.dota2.common.constant.cache.keys.RBACKey).SYSTEM_ROLE_SELECT")
    public void create(SystemRoleFo fo) {
        SystemRole systemRole = new SystemRole();
        BeanUtils.copyProperties(fo, systemRole);
        baseMapper.insert(systemRole);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = RBACCacheConstant.SELECT,key = "T(pers.yurwisher.dota2.common.constant.cache.keys.RBACKey).SYSTEM_ROLE_SELECT")
    public void update(Long id, SystemRoleFo fo) {
        SystemRole systemRole = baseMapper.selectById(id);
        Asserts.notNull(systemRole);
        BeanUtils.copyProperties(fo, systemRole);
        baseMapper.updateById(systemRole);
    }

    @Override
    @SuppressWarnings("unchecked")
    public PageR<SystemRoleTo> list(SystemRoleQo qo) {
        return super.toPageR(baseMapper.list(super.toPage(qo), qo));
    }

    @Override
    public SystemRoleVo get(Long id) {
        return baseMapper.get(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = RBACCacheConstant.SELECT,key = "T(pers.yurwisher.dota2.common.constant.cache.keys.RBACKey).SYSTEM_ROLE_SELECT")
    public void delete(Long id) {
        baseMapper.deleteById(id);
    }

    @Override
    public List<SystemRole> getRoles(String userName) {
        return baseMapper.getRoles(userName);
    }

    @Override
    @Cacheable(value = RBACCacheConstant.USER_ROLE_CODE, key = "#userId",unless = "#result == null")
    public List<String> getRoles(Long userId) {
        logger.info("获取用户角色...");
        return baseMapper.getRolesByUserId(userId);
    }

    @Override
    @Cacheable(value = RBACCacheConstant.SELECT,key = "T(pers.yurwisher.dota2.common.constant.cache.keys.RBACKey).SYSTEM_ROLE_SELECT",unless = "#result == null")
    public List<So<Long>> select() {
        return baseMapper.select();
    }

    @Override
    public List<String> singleRoleMenuAndButton(Long roleId) {
        List<Long> menuIds =  menuService.singleRoleMenu(roleId);
        List<Long> buttonIds = buttonService.singleRoleButton(roleId);
        if(CollectionUtils.isNotEmpty(menuIds)){
            if(CollectionUtils.isNotEmpty(buttonIds)){
                menuIds.addAll(buttonIds);
            }
            //fastjson 即使配置全局对Long的序列化 ToStringSerializer , 序列化 List<Long> 使用的 ListSerializer 未对Long做处理 依旧返回Long
            return menuIds.stream().map(val -> Long.toString(val)).collect(Collectors.toList());
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = RBACCacheConstant.USER_MENU_TREE,allEntries = true)
    public void bindComponent(Long roleId, List<TreeNode> nodes) {
        if(CollectionUtils.isNotEmpty(nodes)){
            Map<ComponentTypeEnum,List<TreeNode>> map = nodes.stream().collect(Collectors.groupingBy(TreeNode::getType));
            //绑定菜单
            List<TreeNode> menus = map.get(ComponentTypeEnum.MENU);
            if(CollectionUtils.isNotEmpty(menus)){
                roleMenuService.bind(roleId,menus.stream().map(TreeNode::getId).collect(Collectors.toList()));
            }
            //绑定按钮
            List<TreeNode> buttons = map.get(ComponentTypeEnum.BUTTON);
            if(CollectionUtils.isNotEmpty(buttons)){
                roleButtonService.bind(roleId,buttons.stream().map(TreeNode::getId).collect(Collectors.toList()));
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void bindPermission(Long id, List<Long> permissionIds) {
        rolePermissionService.bind(id,permissionIds);
    }
}
