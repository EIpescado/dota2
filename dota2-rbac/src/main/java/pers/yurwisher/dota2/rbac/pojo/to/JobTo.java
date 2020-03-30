package pers.yurwisher.dota2.rbac.pojo.to;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * @author yq
 * @date 2019-07-22 17:30:48
 * @description 部门 To
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class JobTo implements Serializable {
    private static final long serialVersionUID = -2823792779052718069L;
    private String name;
    private String department;
    @JSONField(format = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateCreated;
    @JSONField(format = "yyyy-MM-dd HH:mm")
    private LocalDateTime lastUpdated;
    private Long id;
}
