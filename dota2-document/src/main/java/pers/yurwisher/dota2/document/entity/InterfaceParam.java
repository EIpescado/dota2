package pers.yurwisher.dota2.document.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.yurwisher.dota2.common.base.BaseEntity;

/**
 * <p>
 * 请求参数
 * </p>
 *
 * @author yq
 * @since 2019年12月27日 12:23:03
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class InterfaceParam extends BaseEntity {

    /**
     * 参数
     */
    private String code;

    /**
     * 参数描述
     */
    private String description;

    /**
     * 接口ID
     */
    private Long interfaceId;

    /**
     * 父参数ID
     */
    private Long parentId;

    /**
     * 是否必填
     */
    private Boolean required;

    /**
     * 数据类型
     */
    private String dataType;

    /**
     * 默认值
     */
    private String defaultValue;

    /**
     * true 请求参数 ; false 返回参数
     */
    private Boolean requested;
}
