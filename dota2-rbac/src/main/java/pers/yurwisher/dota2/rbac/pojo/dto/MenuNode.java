package pers.yurwisher.dota2.rbac.pojo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.yurwisher.wisp.wrapper.Node;

import java.util.List;
import java.util.Map;

/**
 * @author yq
 * @date 2019/07/19 17:12
 * @description 菜单节点,用于渲染前端页面
 * @since V1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MenuNode extends Node<Long,MenuNode> {

    private String name;

    private Integer sort;

    private String path;

    private String component;

    private String icon;

    private String redirect;

    private Boolean affix;

    private String vueName;

    /**是否隐藏(指左侧边栏)*/
    private Boolean hidden;

    /**keepAlive*/
    private Boolean keepAlive;

    private Map<String,List<ButtonDto>> buttons;

}
