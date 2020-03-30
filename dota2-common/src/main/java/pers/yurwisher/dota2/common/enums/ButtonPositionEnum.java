package pers.yurwisher.dota2.common.enums;

/**
 * @author yq
 * @date 2019/07/24 12:07
 * @description 按钮位置
 * @since V1.0.0
 */
public enum ButtonPositionEnum {
    TOP("顶部按钮"),
    RIGHT("单列按钮"),
    ;

    private String position;

    ButtonPositionEnum(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return position;
    }
}
