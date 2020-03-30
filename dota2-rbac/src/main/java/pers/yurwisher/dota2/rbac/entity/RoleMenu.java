package pers.yurwisher.dota2.rbac.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * <p>
 * 角色菜单关联表
 * </p>
 *
 * @author yq
 * @since 2019-07-10
 */
@Data
public class RoleMenu  {

    @TableId
    private Long id;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 菜单id
     */
    private Long menuId;

}
