package pers.yurwisher.dota2.system.pojo.qo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import pers.yurwisher.dota2.common.wrapper.PageQo;

/**
 * @author yq
 * @date 2019-08-23 10:23:01
 * @description 消息模版 Qo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class MessageTemplateQo extends PageQo {
    private static final long serialVersionUID = 9052966145281657037L;
    private String code;
    private String name;
    private Boolean enabled;
    /**
     * 消息模版类别
     */
    private String type;
}
