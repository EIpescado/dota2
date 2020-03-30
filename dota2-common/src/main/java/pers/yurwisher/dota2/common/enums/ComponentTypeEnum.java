package pers.yurwisher.dota2.common.enums;

/**
 * @author yq
 * @date 2019/07/26 11:08
 * @description 页面组件类型
 * @since V1.0.0
 */
public enum ComponentTypeEnum {

    MENU("菜单"),
    BUTTON("按钮"),
    ;

    private String type;

    ComponentTypeEnum(String type) {
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
