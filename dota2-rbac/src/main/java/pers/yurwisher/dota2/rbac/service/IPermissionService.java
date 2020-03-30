package pers.yurwisher.dota2.rbac.service;

import pers.yurwisher.dota2.common.base.BaseService;
import pers.yurwisher.dota2.rbac.entity.Permission;
import pers.yurwisher.dota2.rbac.pojo.dto.PermissionNode;
import pers.yurwisher.dota2.rbac.pojo.fo.PermissionFo;
import pers.yurwisher.dota2.rbac.pojo.vo.PermissionVo;

import java.util.List;


/**
 * @author yq
 * @date 2019-10-08 14:52:14
 * @description 权限
 * @since V1.0.0
 */
public interface IPermissionService extends BaseService<Permission> {

    /**
     * 新增
     * @param fo 参数
     */
    void create(PermissionFo fo);

    /**
     * 更新
     * @param id 主键
     * @param fo 参数
     */
    void update(Long id,PermissionFo fo);

     /**
     * 删除
     * @param id 主键
     */
    void delete(Long id);

    /**
     * 角色权限树
     * @param roleId 角色ID
     * @return 角色权限树
     */
    List<PermissionNode> tree(Long roleId);

    /**
     * 权限树
     * @return 完整权限树
     */
    List<PermissionNode> fullTree();

    /**
     * 详情
     * @param id ID
     * @return vo
     */
    PermissionVo get(Long id);
}
