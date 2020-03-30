package pers.yurwisher.dota2.system.pojo.portal;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yq
 * @date 2019/10/31 09:29
 * @description 企业描述 资质 3张
 * @since V1.0.0
 */
@Data
public class CompanyOverview implements Serializable {
    private static final long serialVersionUID = -1026886612973567369L;

    /**
     * 资质标题
     */
    private String title;
    /**
     * 资质描述
     */
    private String desc;
    /**
     * 资质背景图 地址
     */
    private String background;
}
