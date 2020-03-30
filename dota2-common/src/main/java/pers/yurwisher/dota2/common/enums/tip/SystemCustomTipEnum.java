package pers.yurwisher.dota2.common.enums.tip;

import pers.yurwisher.wisp.enums.ICustomTipEnum;
import pers.yurwisher.wisp.wrapper.CustomTip;

/**
 * @author yq
 * @date 2019/07/12 11:24
 * @description 系统 自定义提示枚举
 * @since V1.0.0
 */
public enum SystemCustomTipEnum implements ICustomTipEnum {
    DICT_NAME_EXIST(20001,"字典名称已存在"),
    DICT_NAME_CAN_NOT_CHANGE(20002,"字典名称不可修改"),
    ATTACHMENT_SIZE_TOO_LARGE(20003,"上传的附件超过限制大小"),
    ATTACHMENT_INVALID(20004,"上传附件无效"),
    ATTACHMENT_UPLOAD_ERROR(20005,"上传附件失败"),
    ;

    private CustomTip tip;

    SystemCustomTipEnum(int code, String msg) {
        this.tip = CustomTip.of(code,msg);
    }

    @Override
    public CustomTip tip() {
        return tip;
    }
}
