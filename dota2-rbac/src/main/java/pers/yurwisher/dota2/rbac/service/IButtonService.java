package pers.yurwisher.dota2.rbac.service;

import pers.yurwisher.dota2.common.base.BaseService;
import pers.yurwisher.dota2.rbac.entity.Button;
import pers.yurwisher.dota2.rbac.pojo.dto.ButtonDto;
import pers.yurwisher.dota2.rbac.pojo.dto.TreeNode;
import pers.yurwisher.dota2.rbac.pojo.fo.ButtonFo;
import pers.yurwisher.dota2.rbac.pojo.vo.ButtonVo;

import java.util.List;


/**
 * @author yq
 * @date 2019-07-11 16:39:42
 * @description 按钮
 * @since V1.0.0
 */
public interface IButtonService extends BaseService<Button> {

    /**
     * 新增
     * @param fo 参数
     */
    void create(ButtonFo fo);

    /**
     * 更新
     * @param id 主键
     * @param fo 参数
     */
    void update(Long id, ButtonFo fo);

    /**
    * 详情
    * @param id 主键
    * @return ButtonVo
    */
    ButtonVo get(Long id);

     /**
     * 删除
     * @param id 主键
     */
    void delete(Long id);

    /**
     * 用户的所有按钮
     * @param userId 用户ID
     * @return 集合
     */
    List<ButtonDto> findAllByUserId(Long userId);

    /**
     * 所有按钮
     * @return 按钮集合
     */
    List<TreeNode> allButton();

    /**
     * 所有按钮
     * @param roleId 角色ID
     * @return 按钮集合
     */
    List<Long> singleRoleButton(Long roleId);
}
