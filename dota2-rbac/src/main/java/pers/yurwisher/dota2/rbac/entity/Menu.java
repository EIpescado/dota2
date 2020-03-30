package pers.yurwisher.dota2.rbac.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import pers.yurwisher.dota2.common.base.BaseEntity;


/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author yq
 * @since 2019-07-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Menu extends BaseEntity {

    /**
     * 父菜单ID
     */
    private Long parentId;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单路径
     */
    private String path;

    /**
     * 组件名称
     */
    private String component;

    /**
     * 排序号,用于菜单排序
     */
    private Integer rowNo;

    /**
     * 图标
     */
    private String icon;

    /**
     * 是否为外链
     */
    private String redirect;

    /**
     * 是否常驻tab
     */
    private Boolean affix;

    /**菜单在vue中的name, 用于mode history*/
    private String vueName;

    /**是否隐藏(指左侧边栏)*/
    private Boolean hidden;

    /**keepAlive*/
    private Boolean keepAlive;
}
