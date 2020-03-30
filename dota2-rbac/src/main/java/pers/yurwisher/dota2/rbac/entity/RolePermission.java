package pers.yurwisher.dota2.rbac.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author yq
 * @date 2019/10/08 15:01
 * @description 角色-权限关联表
 * @since V1.0.0
 */
@Data
public class RolePermission {

    @TableId
    private Long id;
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 权限ID
     */
    private Long permissionId;
}
