package pers.yurwisher.dota2.document.pojo.to;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author yq
 * @date 2019-11-26 14:20:01
 * @description 接口定义 To
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class InterfaceDefinitionTo implements Serializable {
    private static final long serialVersionUID = -6225730696505619778L;
    private Long id;
    private String code;
    private String module;
    private String description;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateCreated;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastUpdated;

}
