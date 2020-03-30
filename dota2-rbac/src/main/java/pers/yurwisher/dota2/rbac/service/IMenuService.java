package pers.yurwisher.dota2.rbac.service;

import pers.yurwisher.dota2.common.base.BaseService;
import pers.yurwisher.dota2.rbac.entity.Menu;
import pers.yurwisher.dota2.rbac.pojo.dto.MenuNode;
import pers.yurwisher.dota2.rbac.pojo.dto.TreeNode;
import pers.yurwisher.dota2.rbac.pojo.fo.MenuFo;
import pers.yurwisher.dota2.rbac.pojo.vo.MenuVo;

import java.util.List;


/**
 * @author yq
 * @date 2019-07-11 16:34:49
 * @description 菜单
 * @since V1.0.0
 */
public interface IMenuService extends BaseService<Menu> {

    /**
     * 新增
     * @param fo 参数
     */
    void create(MenuFo fo);

    /**
     * 更新
     * @param id 主键
     * @param fo 参数
     */
    void update(Long id, MenuFo fo);

    /**
    * 详情
    * @param id 主键
    * @return MenuVo
    */
    MenuVo get(Long id);

     /**
     * 删除
     * @param id 主键
     */
    void delete(Long id);

    /**
     * 获取当前用户的菜单树
     * @param userId 用户ID
     * @return list
     */
    List<MenuNode> tree(Long userId);

    /**
     * 所有菜单
     * @return 所有菜单
     */
    List<TreeNode> fullTree();

    /**
     * 单个角色所有菜单
     * @param roleId 角色ID
     * @return 所有菜单
     */
    List<Long> singleRoleMenu(Long roleId);
}
