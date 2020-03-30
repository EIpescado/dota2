package pers.yurwisher.dota2.system.pojo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author yq
 * @date 2019-10-14 13:55:36
 * @description 字典 Vo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DictVo implements Serializable {
    private static final long serialVersionUID = 7644570047728491979L;
    private String name;
    private String description;
}
