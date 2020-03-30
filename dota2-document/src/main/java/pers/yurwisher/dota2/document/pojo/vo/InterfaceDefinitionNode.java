package pers.yurwisher.dota2.document.pojo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.yurwisher.wisp.wrapper.Node;

/**
 * @author yq
 * @date 2019-11-26 14:20:01
 * @description 接口节点
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class InterfaceDefinitionNode extends Node<Long,InterfaceDefinitionNode> {

    private String code;
    private String module;
    private String description;

}
