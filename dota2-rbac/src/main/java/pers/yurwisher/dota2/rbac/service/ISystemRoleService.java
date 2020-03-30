package pers.yurwisher.dota2.rbac.service;

import pers.yurwisher.dota2.common.base.BaseService;
import pers.yurwisher.dota2.rbac.entity.SystemRole;
import pers.yurwisher.dota2.rbac.pojo.dto.TreeNode;
import pers.yurwisher.dota2.rbac.pojo.fo.SystemRoleFo;
import pers.yurwisher.dota2.rbac.pojo.qo.SystemRoleQo;
import pers.yurwisher.dota2.rbac.pojo.to.SystemRoleTo;
import pers.yurwisher.dota2.rbac.pojo.vo.SystemRoleVo;
import pers.yurwisher.wisp.wrapper.PageR;
import pers.yurwisher.wisp.wrapper.So;

import java.util.List;


/**
 * @author yq
 * @date 2019-07-11 16:38:43
 * @description 角色
 * @since V1.0.0
 */
public interface ISystemRoleService extends BaseService<SystemRole> {

    /**
     * 新增
     * @param fo 参数
     */
    void create(SystemRoleFo fo);

    /**
     * 更新
     * @param id 主键
     * @param fo 参数
     */
    void update(Long id, SystemRoleFo fo);

    /**
     * 列表
     * @param qo 查询参数
     * @return 分页对象
     */
    PageR<SystemRoleTo> list(SystemRoleQo qo);


    /**
    * 详情
    * @param id 主键
    * @return SystemRoleVo
    */
    SystemRoleVo get(Long id);

     /**
     * 删除
     * @param id 主键
     */
    void delete(Long id);

    /**
     * 获取用户角色
     * @param userName 用户名
     * @return 角色集合
     */
    List<SystemRole> getRoles(String userName);

    /**
     * 获取用户角色编码集合
     * @param userId 用户Id
     * @return 角色集合
     */
    List<String> getRoles(Long userId);

    /**
     * 获取此级别下的所有角色信息
     * @return select
     */
    List<So<Long>> select();

    /**
     * 单个角色拥有的菜单和按钮集合
     * @param roleId 角色编码
     * @return id集合
     */
    List<String> singleRoleMenuAndButton(Long roleId);

    /**
     * 角色绑定 组件(页面和按钮)
     * @param roleId 角色id
     * @param nodes 组件
     */
    void bindComponent(Long roleId,List<TreeNode> nodes);

    /**
     * 角色绑定权限
     * @param id 角色ID
     * @param permissionIds 权限ID
     */
    void bindPermission(Long id, List<Long> permissionIds);
}
