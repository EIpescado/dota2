package pers.yurwisher.dota2.system.pojo.qo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import pers.yurwisher.dota2.common.wrapper.PageQo;

/**
 * @author yq
 * @date 2019-10-15 11:33:43
 * @description 状态日志查询 Qo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class StatusLogQo extends PageQo {
    private static final long serialVersionUID = 3944652401237656626L;

   private Long entityId;
    private String entityClassName;
}
