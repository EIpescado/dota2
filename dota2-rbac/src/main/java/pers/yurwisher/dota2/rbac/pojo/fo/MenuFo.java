package pers.yurwisher.dota2.rbac.pojo.fo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
/**
 * @author yq
 * @date 2019-07-11 16:34:49
 * @description 菜单 Fo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MenuFo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long parentId;
    private String menuName;
    private String path;
    private String component;
    private Integer rowNo;
    /**
     * 图标
     */
    private String icon;

    /**
     * 跳转
     */
    private String redirect;

    private Boolean affix;

    private String vueName;

    /**是否隐藏(指左侧边栏)*/
    private Boolean hidden;
    /**keepAlive*/
    private Boolean keepAlive;
}
