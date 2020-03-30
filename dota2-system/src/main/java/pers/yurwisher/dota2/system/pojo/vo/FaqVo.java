package pers.yurwisher.dota2.system.pojo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author yq
 * @date 2019-10-15 11:33:43
 * @description 字典明细 Vo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FaqVo implements Serializable {
    private static final long serialVersionUID = 3605137816644149358L;
    private String question;
    private String answer;
    private String type;
    private Integer sort;
}
