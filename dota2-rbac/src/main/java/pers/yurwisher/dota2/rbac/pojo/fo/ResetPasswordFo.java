package pers.yurwisher.dota2.rbac.pojo.fo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yq
 * @date 2018/11/16 09:38
 * @description 重置密码
 * @since V1.0.0
 */
@Data
public class ResetPasswordFo implements Serializable {
    private static final long serialVersionUID = 984897616818417570L;

    /**
     * 原始密码
     */
    private String originalPassword;
    /**
     * 新密码
     */
    private String newPassword;
    /**
     * 重新输入新密码
     */
    private String reEnterNewPassword;
}
