package pers.yurwisher.dota2.system.pojo.to;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author yq
 * @date 2019-11-11 22:29:20
 * @description 状态日志 To
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class StatusLogTo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String operator;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime changeDate;
    private String remark;
    private String status;
}
