package pers.yurwisher.dota2.document.pojo.fo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author yq
 * @date 2019-11-26 14:20:01
 * @description 接口定义 Fo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class InterfaceDefinitionFo implements Serializable {
    private static final long serialVersionUID = -2397994666132461774L;
    /**项目*/
    private String module;
    /**接口编码*/
    private String code;
    /**描述*/
    private String description;
    /**请求头*/
    private List<RequestHeadFo> requestHeaders;
    /**请求参数*/
    private List<InterfaceParamFo> requestParams;
    /**响应参数*/
    private List<InterfaceParamFo> responseParams;
}
