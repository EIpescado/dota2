package pers.yurwisher.dota2.rbac.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.yurwisher.dota2.common.base.impl.BaseServiceImpl;
import pers.yurwisher.dota2.rbac.entity.Permission;
import pers.yurwisher.dota2.rbac.mapper.PermissionMapper;
import pers.yurwisher.dota2.rbac.pojo.dto.PermissionNode;
import pers.yurwisher.dota2.rbac.pojo.fo.PermissionFo;
import pers.yurwisher.dota2.rbac.pojo.vo.PermissionVo;
import pers.yurwisher.dota2.rbac.service.IPermissionService;
import pers.yurwisher.wisp.utils.Asserts;
import pers.yurwisher.wisp.utils.CollectionUtils;
import pers.yurwisher.wisp.wrapper.Tree;

import java.util.List;

/**
 * @author yq
 * @date 2019-10-08 14:52:14
 * @description 权限
 * @since V1.0.0
 */
@Service
public class PermissionServiceImpl extends BaseServiceImpl<PermissionMapper,Permission> implements IPermissionService{

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(PermissionFo fo){
        Permission permission = new Permission();
        BeanUtils.copyProperties(fo,permission);
        baseMapper.insert(permission);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Long id,PermissionFo fo){
        Permission permission = baseMapper.selectById(id);
        Asserts.notNull(permission);
        BeanUtils.copyProperties(fo,permission);
        baseMapper.updateById(permission);
    }

     /**
     * 删除
     * @param id 主键
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id){
        baseMapper.deleteById(id);
    }

    @Override
    public List<PermissionNode> tree(Long roleId) {
        List<PermissionNode> permissionNodes = baseMapper.findAllByRoleId(roleId);
        if(CollectionUtils.isNotEmpty(permissionNodes)){
            return new Tree<Long, PermissionNode>(-1L).build(permissionNodes);
        }
        return null;
    }

    @Override
    public List<PermissionNode> fullTree() {
        List<PermissionNode> permissionNodes = baseMapper.findAllPermission();
        if(CollectionUtils.isNotEmpty(permissionNodes)){
            return new Tree<Long, PermissionNode>(-1L).build(permissionNodes);
        }
        return null;
    }

    @Override
    public PermissionVo get(Long id) {
        return baseMapper.get(id);
    }
}
