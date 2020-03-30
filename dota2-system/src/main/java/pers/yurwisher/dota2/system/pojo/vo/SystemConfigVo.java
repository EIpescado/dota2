package pers.yurwisher.dota2.system.pojo.vo;

import lombok.Data;

/**
 * @author yq
 * @date 2018/12/05 09:08
 * @description 系统配置
 * @since V1.0.0
 */
@Data
public class SystemConfigVo {

    /**
     * 配置名称
     */
    private String name;

    /**
     * 配置编码
     */
    private String code;

    /**
     * 配置值
     */
    private String val;
}
