package pers.yurwisher.dota2.system.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.yurwisher.dota2.common.base.BaseEntity;

/**
 * @author yq
 * @date 2019/10/14 13:51
 * @description 字典 明细
 * @since V1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class DictMember extends BaseEntity {

    private String val;
    private String description;
    private Integer sort;
    private String dictName;
}
