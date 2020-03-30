package pers.yurwisher.dota2.system.pojo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author yq
 * @date 2019-10-14 13:56:10
 * @description 字典明细 Vo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DictMemberVo implements Serializable {
    private static final long serialVersionUID = 744574914704304349L;
    private String val;
    private String description;
    private Integer sort;
    private String dictName;
}
