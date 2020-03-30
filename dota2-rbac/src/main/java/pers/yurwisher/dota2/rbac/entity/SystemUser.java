package pers.yurwisher.dota2.rbac.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import pers.yurwisher.dota2.common.base.BaseEntity;
import pers.yurwisher.dota2.common.enums.UserStatusEnum;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统用户
 * </p>
 *
 * @author yq
 * @since 2019-07-10
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SystemUser extends BaseEntity {

    /**
     * 用户名
     */
    private String username;

    /**
     * 注册日期
     */
    private LocalDateTime registerDate;

    /**
     * 密码
     */
    private String password;

    /**
     * 最后密码重置时间
     */
    private LocalDateTime lastPasswordResetDate;

    /**
     * 用户状态
     */
    private UserStatusEnum status;

}
