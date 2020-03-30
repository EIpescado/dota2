package pers.yurwisher.dota2.rbac.pojo.qo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import pers.yurwisher.dota2.common.wrapper.PageQo;

/**
 * @author yq
 * @date 2019-07-22 17:30:48
 * @description 部门 Qo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class JobQo extends PageQo {
    private static final long serialVersionUID = 6565607305440895551L;
    private String name;
    private Long departmentId;
}
