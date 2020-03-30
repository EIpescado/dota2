package pers.yurwisher.dota2.rbac.pojo.dto;

import lombok.Data;

/**
 * @author yq
 * @date 2019/07/24 11:55
 * @description 按钮,用于渲染前端页面
 * @since V1.0.0
 */
@Data
public class ButtonDto {

    private Long id;

    /**
     * 按钮名称
     */
    private String buttonName;
    /**
     * 按钮图标
     */
    private String icon;
    /**
     * 标识 T 顶部, R 列表操作栏
     */
    private String position;
    /**
     * 点击后触发的函数名称
     */
    private String click;

    private Long menuId;
}
