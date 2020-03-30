package pers.yurwisher.dota2.common.enums;

/**
 * @author yq
 * @date 2019/08/16 09:48
 * @description 消息类型
 * @since V1.0.0
 */
public enum MessageTypeEnum {
    NOTICE("公告消息"),
    SYSTEM("系统消息"),
    WEB("站内信"),
    ;

    private String type;

    MessageTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
