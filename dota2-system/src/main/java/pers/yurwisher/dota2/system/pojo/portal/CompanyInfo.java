package pers.yurwisher.dota2.system.pojo.portal;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author yq
 * @date 2019/10/31 09:50
 * @description 网页上的其他信息
 * @since V1.0.0
 */
@Data
public class CompanyInfo implements Serializable {
    private static final long serialVersionUID = 7840713560717471701L;
    /**
     * 公司名称
     */
    private String companyName;
    /**
     * 网站ICP备案号
     */
    private String icp;
    /**
     * logo文件地址
     */
    private String logoSrc;
    /**
     * 客服热线
     */
    private List<PhoneAndMail> service;
    /**
     * 投诉电话
     */
    private List<PhoneAndMail> complain;
    /**
     * 商务合作
     */
    private List<PhoneAndMail> business;

    /**
     * 手机及电话
     */
    @Data
    public static class PhoneAndMail implements Serializable{
        private static final long serialVersionUID = -8066439685059704564L;
        private String phone;
        private String mail;
    }
}
