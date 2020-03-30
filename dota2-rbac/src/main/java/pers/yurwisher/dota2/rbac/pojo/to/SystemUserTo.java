package pers.yurwisher.dota2.rbac.pojo.to;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author yq
 * @date 2019-07-10 16:59:09
 * @description 用户 To
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SystemUserTo implements Serializable {
    private static final long serialVersionUID = -7541265183417204356L;
    private String username;
    @JSONField(format = "yyyy-MM-dd HH:mm")
    private LocalDateTime registerDate;
    private Long id;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastPasswordResetDate;
}
