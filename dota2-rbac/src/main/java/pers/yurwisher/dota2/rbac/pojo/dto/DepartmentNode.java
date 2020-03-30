package pers.yurwisher.dota2.rbac.pojo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.yurwisher.wisp.wrapper.Node;

/**
 * @author yq
 * @date 2019/07/23 11:09
 * @description 部门节点
 * @since V1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DepartmentNode extends Node<Long,DepartmentNode> {
    private String name;
    private Integer rowNo;
}
