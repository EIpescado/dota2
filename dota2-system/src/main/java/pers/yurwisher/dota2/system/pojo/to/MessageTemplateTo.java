package pers.yurwisher.dota2.system.pojo.to;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author yq
 * @date 2019-08-23 10:23:01
 * @description 消息模版 To
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MessageTemplateTo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String code;
    private String name;
    private String template;
    @JSONField(format = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateCreated;
    @JSONField(format = "yyyy-MM-dd HH:mm")
    private LocalDateTime lastUpdated;
    private Boolean whetherNeedFormat;
    private Long id;
    /**
     * 消息模版类别
     */
    private String type;
}
