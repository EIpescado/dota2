package pers.yurwisher.dota2.rbac.pojo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
/**
 * @author yq
 * @date 2019-07-11 16:34:49
 * @description 菜单 Vo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MenuVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String menuName;
    private String path;
    private String component;
    private Integer rowNo;
    private Long id;
    private Boolean enabled;

    private Long parentId;
    /**
     * 图标
     */
    private String icon;

    /**
     * 是否为外链
     */
    private String redirect;

    private Boolean affix;

    private String vueName;

    /**是否隐藏(指左侧边栏)*/
    private Boolean hidden;

    /**keepAlive*/
    private Boolean keepAlive;
}
