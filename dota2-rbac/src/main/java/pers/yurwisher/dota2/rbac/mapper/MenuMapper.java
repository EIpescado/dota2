package pers.yurwisher.dota2.rbac.mapper;

import org.apache.ibatis.annotations.Param;
import pers.yurwisher.dota2.common.base.CommonMapper;
import pers.yurwisher.dota2.rbac.entity.Menu;
import pers.yurwisher.dota2.rbac.pojo.dto.MenuNode;
import pers.yurwisher.dota2.rbac.pojo.dto.TreeNode;
import pers.yurwisher.dota2.rbac.pojo.vo.MenuVo;

import java.util.List;

/**
 * @author yq
 * @date 2019-07-11 16:34:49
 * @description 菜单 Mapper
 * @since V1.0.0
 */
public interface MenuMapper extends CommonMapper<Menu> {

    /**
    * 详情
    * @param id ID
    * @return 详情
    */
    MenuVo get(@Param("id") Long id);

    /**
     * 获取用户菜单
     * @param userId 用户
     * @return 菜单集合
     */
    List<MenuNode> findAllByUserId(@Param("userId") Long userId);

    /**
     * 所有菜单
     * @return 所有菜单
     */
    List<TreeNode> findAllForFullTree();

    /**
     * 单个角色的所有菜单
     * @param roleId 角色ID
     * @return 集合
     */
    List<Long> findAllByRoleId(@Param("roleId")Long roleId);
}
