package pers.yurwisher.dota2.rbac.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import pers.yurwisher.dota2.common.base.BaseEntity;
import pers.yurwisher.dota2.common.enums.ButtonPositionEnum;

import java.time.LocalDateTime;

/**
 * <p>
 * 按钮
 * </p>
 *
 * @author yq
 * @since 2019-07-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Button extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 按钮名称
     */
    private String buttonName;

    /**
     * 菜单ID
     */
    private Long menuId;

    /**
     * 排序号,用于按钮排序
     */
    private Integer rowNo;

    /**
     * 按钮图标
     */
    private String icon;
    /**
     * 位置 T 顶部, R 列表操作栏
     */
    private ButtonPositionEnum position;
    /**
     * 点击后触发的函数名称
     */
    private String click;

}
