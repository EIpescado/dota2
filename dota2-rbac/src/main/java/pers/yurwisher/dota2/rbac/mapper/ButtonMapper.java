package pers.yurwisher.dota2.rbac.mapper;

import org.apache.ibatis.annotations.Param;
import pers.yurwisher.dota2.common.base.CommonMapper;
import pers.yurwisher.dota2.rbac.entity.Button;
import pers.yurwisher.dota2.rbac.pojo.dto.ButtonDto;
import pers.yurwisher.dota2.rbac.pojo.dto.TreeNode;
import pers.yurwisher.dota2.rbac.pojo.vo.ButtonVo;

import java.util.List;

/**
 * @author yq
 * @date 2019-07-11 16:39:42
 * @description 按钮 Mapper
 * @since V1.0.0
 */
public interface ButtonMapper extends CommonMapper<Button> {

    /**
    * 详情
    * @param id ID
    * @return 详情
    */
    ButtonVo get(@Param("id") Long id);

    /**
     * 获取用户的所有按钮
     * @param userId 用户ID
     * @return 按钮集合
     */
    List<ButtonDto> findAllByUserId(@Param("userId")Long userId);

    /**
     * 所有按钮
     * @return list
     */
    List<TreeNode> allButton();

    /**
     *  单个角色的所有按钮ID
     * @param roleId 角色ID
     * @return list
     */
    List<Long> findAllButtonIdByRoleId(@Param("roleId")Long roleId);
}
