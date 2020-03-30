package pers.yurwisher.dota2.system.pojo.portal;

import lombok.Data;

import java.util.List;

/**
 * @author yq
 * @date 2019/10/31 10:12
 * @description 企业门户信息
 * @since V1.0.0
 */
@Data
public class WebInfo {
    private String remark;
    /**
     * 企业资质 3
     */
    private List<CompanyOverview> companyOverviews;
    /**
     * 合作伙伴
     */
    private List<CompanyPartner> companyPartners;

    /**
     * 其他信息
     */
    private CompanyInfo companyInfo;

    /**
     * 走马灯
     */
    private List<Carousel> carousels;

    /**关于我们*/
    private AboutUs aboutUs;

    /**在线客服信息*/
    private OnlineServiceInfo onlineServiceInfo;
}
