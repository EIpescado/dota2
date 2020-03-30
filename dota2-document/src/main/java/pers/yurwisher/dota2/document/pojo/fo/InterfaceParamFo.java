package pers.yurwisher.dota2.document.pojo.fo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author yq
 * @date 2019-11-26 14:42:33
 * @description 接口参数 Fo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class InterfaceParamFo implements Serializable {
    private static final long serialVersionUID = 609226707876282220L;
    private String code;
    private String description;
    private Boolean required;
    private String dataType;
    private String defaultValue;

    List<InterfaceParamFo> children;
}
