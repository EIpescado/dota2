package pers.yurwisher.dota2.rbac.pojo.fo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
/**
 * @author yq
 * @date 2019-07-22 17:30:48
 * @description 部门 Fo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class JobFo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private Long departmentId;
    private Integer rowNo;
}
