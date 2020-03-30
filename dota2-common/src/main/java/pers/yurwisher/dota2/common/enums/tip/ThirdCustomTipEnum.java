package pers.yurwisher.dota2.common.enums.tip;

import pers.yurwisher.wisp.enums.ICustomTipEnum;
import pers.yurwisher.wisp.wrapper.CustomTip;

/**
 * @author yq
 * @date 2019/07/12 11:24
 * @description 系统 自定义提示枚举
 * @since V1.0.0
 */
public enum ThirdCustomTipEnum implements ICustomTipEnum {
    SEND_MESSAGE_TOO_MUCH(30020,"发送短信过于频繁,请稍后重试"),
    UPLOAD_FILE_FAIL(30021,"上传文件失败,请稍后重试"),
    ;

    private CustomTip tip;

    ThirdCustomTipEnum(int code, String msg) {
        this.tip = CustomTip.of(code,msg);
    }

    @Override
    public CustomTip tip() {
        return tip;
    }
}
