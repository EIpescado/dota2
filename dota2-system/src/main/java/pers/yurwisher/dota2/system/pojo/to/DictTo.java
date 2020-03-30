package pers.yurwisher.dota2.system.pojo.to;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author yq
 * @date 2019-10-14 13:55:36
 * @description 字典 To
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DictTo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String description;
    private Long id;
    private Boolean enabled;
}
