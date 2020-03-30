package pers.yurwisher.dota2.document.pojo.qo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import pers.yurwisher.dota2.common.wrapper.PageQo;

/**
 * @author yq
 * @date 2019-11-26 14:20:01
 * @description 接口定义 Qo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class InterfaceDefinitionQo extends PageQo {
    private static final long serialVersionUID = 4845275732169052407L;
    private String code;
    private String module;
    private String description;
}
