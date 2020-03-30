package pers.yurwisher.dota2.rbac.pojo.fo;

import lombok.Data;
import java.io.Serializable;

/**
 * @author yq
 * @date 2019/09/26 11:35
 * @description 用户注册 表单
 * @since V1.0.0
 */
@Data
public class SystemUserRegisterFo implements Serializable {
    private static final long serialVersionUID = -6164105597853229008L;

    /**用户名 手机注册*/
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 重新输入密码
     */
    private String reEnterPassword;
    /**
     * 短信验证码
     */
    private String validCode;

}
