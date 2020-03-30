package pers.yurwisher.dota2.rbac.pojo.fo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import pers.yurwisher.dota2.common.enums.ButtonPositionEnum;

import java.io.Serializable;

/**
 * @author yq
 * @date 2019-07-11 16:39:42
 * @description 按钮 Fo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ButtonFo implements Serializable {
    private static final long serialVersionUID = -831101461622107111L;
    private String buttonName;
    private Long menuId;
    private Integer rowNo;
    /**
     * 按钮图标
     */
    private String icon;
    /**
     * 位置 T 顶部, R 列表操作栏
     */
    private ButtonPositionEnum position;
    /**
     * 点击后触发的函数名称
     */
    private String click;
}
