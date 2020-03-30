package pers.yurwisher.dota2.system.pojo.fo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author yq
 * @date 2019-08-23 10:23:01
 * @description 消息模版 Fo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MessageTemplateFo implements Serializable {
    private static final long serialVersionUID = 4426529614750463583L;
    private String code;
    private String name;
    private String template;
    /**
     * 消息模版类别
     */
    private String type;
    private Boolean whetherNeedFormat;
}
