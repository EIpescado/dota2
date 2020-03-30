package pers.yurwisher.dota2.document.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.yurwisher.dota2.common.base.BaseEntity;

/**
 * 接口
 * @author yq 2019年12月27日 12:22:33
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class InterfaceDefinition extends BaseEntity {

    /**
     * 接口代码
     */
    private String code;
    /**
     * 模块名称
     */
    private String module;

    /**
     * 接口描述
     */
    private String description;

}
