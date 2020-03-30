package pers.yurwisher.dota2.rbac.pojo.fo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yq
 * @date 2019/10/16 18:40
 * @description 找回密码
 * @since V1.0.0
 */
@Data
public class RetrievePasswordFo implements Serializable {
    private static final long serialVersionUID = -7612473529619035368L;

    /**
     * 手机号
     */
    private String phone;
    /**
     * step1 图片验证码
     */
    private String validCode;
    /**
     * step1 验证码UUID
     */
    private String uuid;


    /**
     * step2 短信验证码
     */
    private String phoneValidCode;



    /**
     * step3 新密码
     */
    private String password;
    /**
     * step3 重新输入新密码
     */
    private String reEnterPassword;

}
