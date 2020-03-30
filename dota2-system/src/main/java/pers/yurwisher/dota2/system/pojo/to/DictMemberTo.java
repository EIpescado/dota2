package pers.yurwisher.dota2.system.pojo.to;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author yq
 * @date 2019-10-14 13:56:10
 * @description 字典明细 To
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DictMemberTo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String val;
    private String description;
    private Integer sort;
    private Long id;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastUpdated;
}
