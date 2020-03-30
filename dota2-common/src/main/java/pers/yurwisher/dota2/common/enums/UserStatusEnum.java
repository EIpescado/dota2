package pers.yurwisher.dota2.common.enums;

import pers.yurwisher.wisp.enums.ICustomStatusEnum;
import pers.yurwisher.wisp.wrapper.CustomStatus;

/**
 * @author yq
 * @date 2019/10/15 17:02
 * @description 用户状态
 * @since V1.0.0
 */
public enum UserStatusEnum implements ICustomStatusEnum {

    NORMAL("NORMAL","正常",1),
    DISABLED("DISABLED","已禁用",2),
    ;

    private CustomStatus status;

    UserStatusEnum(String code, String desc, Integer sort) {
        this.status = CustomStatus.of(code,desc,sort);
    }

    @Override
    public CustomStatus status() {
        return status;
    }

    @Override
    public String toString() {
        return status.getDesc();
    }
}
