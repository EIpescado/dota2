package pers.yurwisher.dota2.rbac.pojo.qo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import pers.yurwisher.dota2.common.wrapper.PageQo;

/**
 * @author yq
 * @date 2019-07-10 16:59:09
 * @description 用户 Qo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SystemUserQo extends PageQo {
    private static final long serialVersionUID = 5153527498686327700L;
    private String username;
    private String status;
}
