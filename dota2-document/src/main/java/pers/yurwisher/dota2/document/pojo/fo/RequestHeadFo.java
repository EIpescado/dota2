package pers.yurwisher.dota2.document.pojo.fo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author yq
 * @date 2019-11-27 11:16:10
 * @description 请求头 Fo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RequestHeadFo implements Serializable {
    private static final long serialVersionUID = -1746489311667834737L;
    private String code;
    private Boolean required;
    private String defaultValue;
    private String description;
}
