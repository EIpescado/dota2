package pers.yurwisher.dota2.rbac.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * <p>
 * 用户角色关联表
 * </p>
 *
 * @author yq
 * @since 2019-07-10
 */
@Data
public class UserRole {

    @TableId
    private Long id;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 用户ID
     */
    private Long userId;


}
