package pers.yurwisher.dota2.document.pojo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.yurwisher.wisp.wrapper.Node;

/**
 * @author yq
 * @date 2019-11-26 14:42:33
 * @description 接口参数 Vo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class InterfaceParamNode extends Node<Long,InterfaceParamNode> {
    private String code;
    private String description;
    private Boolean required;
    private String dataType;
    private String defaultValue;
    private Boolean requested;
}
