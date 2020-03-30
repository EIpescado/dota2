package pers.yurwisher.dota2.document.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.yurwisher.dota2.common.base.BaseEntity;

/**
 * 请求头
 * @author yq 2019年12月27日 12:23:28
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RequestHead extends BaseEntity {

    /**
     * 接口ID
     */
    private Long interfaceId;

    /**
     * head code
     */
    private String code;

    /**
     * 是否必填
     */
    private Boolean required;

    /**
     * 默认值
     */
    private String defaultValue;

    /**
     * 参数描述
     */
    private String description;


}
