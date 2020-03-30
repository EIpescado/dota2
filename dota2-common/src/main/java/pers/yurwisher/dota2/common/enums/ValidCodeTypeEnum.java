package pers.yurwisher.dota2.common.enums;

/**
 * @author yq
 * @date 2019/10/15 17:02
 * @description 验证码类型类型
 * @since V1.0.0
 */
public enum ValidCodeTypeEnum {

    R("注册验证码"),
    RP("找回密码验证码"),
    ;

    private String type;

    ValidCodeTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
}
