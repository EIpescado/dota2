package pers.yurwisher.dota2.common.enums.tip;

import pers.yurwisher.wisp.enums.ICustomTipEnum;
import pers.yurwisher.wisp.wrapper.CustomTip;

/**
 * @author yq
 * @date 2019/07/12 11:24
 * @description RBAC 自定义提示枚举
 * @since V1.0.0
 */
public enum RBACCustomTipEnum implements ICustomTipEnum {
    GENERATE_VALID_CODE_ERROR(10001,"验证码生成失败"),
    VALID_CODE_EXPIRED(10002,"验证码已失效"),
    VALID_CODE_ERROR(10003,"验证码错误"),
    USER_DISABLED(10004,"帐号已被禁用"),
    USER_NAME_OR_PASSWORD_ERROR(10005,"帐号或密码错误"),
    LOGIN_PLEASE(10006,"请登录"),
    USER_ACCESS_DENIED(10007,"无权访问"),
    BAD_CREDENTIALS(10008,"无效凭证"),
    REFRESH_TOKEN(10009,"刷新token"),
    LOGIN_EXPIRED(10010,"登录已过期"),
    TWO_PASSWORD_IN_CONFORMITY(10011,"两次输入的密码不一致"),
    USER_NAME_HAVE_BEEN_USED(10012,"用户名已被使用"),
    PHONE_HAVE_BEEN_USED(10013,"手机号已被使用"),
    USER_NAME_NOT_EXIST(10014,"账号不存在"),
    RETRIEVE_PASSWORD_EXPIRED(10015,"找回密码操作已失效"),
    ;

    private CustomTip tip;

    RBACCustomTipEnum(int code, String msg) {
        this.tip = CustomTip.of(code,msg);
    }

    @Override
    public CustomTip tip() {
        return tip;
    }
}
