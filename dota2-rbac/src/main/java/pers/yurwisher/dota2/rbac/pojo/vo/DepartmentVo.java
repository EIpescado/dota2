package pers.yurwisher.dota2.rbac.pojo.vo;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * @author yq
 * @date 2019-07-22 17:11:02
 * @description 部门 Vo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DepartmentVo implements Serializable {
    private static final long serialVersionUID = -195266227257026676L;
    private String name;
    private Long parentId;
    private Integer rowNo;
}
