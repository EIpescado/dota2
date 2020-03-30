package pers.yurwisher.dota2.rbac.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.yurwisher.dota2.common.base.BaseEntity;

import java.time.LocalDateTime;

/**
 * @author yq
 * @date 2019/10/08 14:47
 * @description 权限
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Permission extends BaseEntity {

    /**
     * 权限名称
     */
    private String permissionName;
    /**
     * 权限编码(对应后端接口)
     */
    private String permissionCode;

    /**
     * 父权限ID
     */
    private Long parentId;
}
