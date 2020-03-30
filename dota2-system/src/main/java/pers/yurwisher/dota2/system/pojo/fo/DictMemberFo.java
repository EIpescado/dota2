package pers.yurwisher.dota2.system.pojo.fo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author yq
 * @date 2019-10-14 13:56:10
 * @description 字典明细 Fo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DictMemberFo implements Serializable {
    private static final long serialVersionUID = -3333433763523237617L;
    private String val;
    private String description;
    private Integer sort;
    private String dictName;
}
