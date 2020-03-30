package pers.yurwisher.dota2.system.pojo.portal;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yq
 * @date 2019/11/05 10:25
 * @description 关于我们
 * @since V1.0.0
 */
@Data
public class AboutUs implements Serializable {
    private static final long serialVersionUID = 8569572322722904566L;

    private String companyName;

    /**公司简介*/
    private String intro;

    /**公司地址*/
    private String address;

    private String tel;

    private String mail;

    /**网址*/
    private String website;

    /**微信公众号二维码*/
    private String weChatMpQrCode;

    /**用户协议*/
    private String userAgreement;
}
