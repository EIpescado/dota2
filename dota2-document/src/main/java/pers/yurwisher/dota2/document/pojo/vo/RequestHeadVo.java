package pers.yurwisher.dota2.document.pojo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author yq
 * @date 2019-11-27 11:16:10
 * @description 请求头 Vo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RequestHeadVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String code;
    private Boolean required;
    private String defaultValue;
    private String description;
    private Long id;
}
