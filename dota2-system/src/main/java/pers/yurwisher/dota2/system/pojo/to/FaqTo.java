package pers.yurwisher.dota2.system.pojo.to;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author yq
 * @date 2019-10-15 11:33:43
 * @description 字典明细 To
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FaqTo implements Serializable {
    private static final long serialVersionUID = -3085140420793083017L;
    private String question;
    private String answer;
    private String type;
    @JSONField(format = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateCreated;
    @JSONField(format = "yyyy-MM-dd HH:mm")
    private LocalDateTime lastUpdated;
    private Long id;
    private Integer sort;
}
