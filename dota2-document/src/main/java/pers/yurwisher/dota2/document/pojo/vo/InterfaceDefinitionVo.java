package pers.yurwisher.dota2.document.pojo.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author yq
 * @date 2019-11-26 14:20:01
 * @description 接口定义 Vo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class InterfaceDefinitionVo implements Serializable {
    private static final long serialVersionUID = 1122672867616050678L;
    private Long id;
    private String code;
    private String module;
    private String description;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastUpdated;

    /**请求头*/
    private List<RequestHeadVo> requestHeaders;
    /**请求参数*/
    private List<InterfaceParamNode> requestParams;
    /**响应参数*/
    private List<InterfaceParamNode> responseParams;
}
