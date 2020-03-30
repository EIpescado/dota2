package pers.yurwisher.dota2.rbac.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * <p>
 * 角色按钮关联表
 * </p>
 *
 * @author yq
 * @since 2019-07-10
 */
@Data
public class RoleButton {

    @TableId
    private Long id;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 按钮ID
     */
    private Long buttonId;


}
