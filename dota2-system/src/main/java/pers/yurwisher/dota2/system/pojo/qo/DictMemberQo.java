package pers.yurwisher.dota2.system.pojo.qo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import pers.yurwisher.dota2.common.wrapper.PageQo;

/**
 * @author yq
 * @date 2019-10-14 13:56:10
 * @description 字典明细 Qo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class DictMemberQo extends PageQo {
    private static final long serialVersionUID = -2030029861502766808L;
    private String description;
    private String dictName;
}
