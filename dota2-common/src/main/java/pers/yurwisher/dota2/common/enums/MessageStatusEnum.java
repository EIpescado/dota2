package pers.yurwisher.dota2.common.enums;

/**
 * @author yq
 * @date 2019/07/11 10:16
 * @description 性别枚举
 * @since V1.0.0
 */
public enum MessageStatusEnum {
    UN_READ("未读"),
    ALREADY_READ("已读"),
    ;

    private String status;

    MessageStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
