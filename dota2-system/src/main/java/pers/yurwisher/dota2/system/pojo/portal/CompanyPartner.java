package pers.yurwisher.dota2.system.pojo.portal;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yq
 * @date 2019/10/31 09:55
 * @description 公司合作伙伴
 * @since V1.0.0
 */
@Data
public class CompanyPartner implements Serializable {
    private static final long serialVersionUID = 1500883794120757511L;

    /**
     * 伙伴名称
     */
    private String name;

    /**
     * 图片地址
     */
    private String imageUrl;
}
