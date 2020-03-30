package pers.yurwisher.dota2.rbac.pojo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.yurwisher.wisp.wrapper.Node;

/**
 * @author yq
 * @date 2019/07/23 11:09
 * @description 权限节点
 * @since V1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PermissionNode extends Node<Long, PermissionNode> {
    private String name;
}
