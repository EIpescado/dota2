package pers.yurwisher.dota2.system.pojo.portal;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yq
 * @date 2019/11/03 14:05
 * @description 走马灯
 * @since V1.0.0
 */
@Data
public class Carousel implements Serializable {
    private static final long serialVersionUID = -6909250024868462766L;

    /**
     * 产品id
     */
    private Long productId;
    /**
     * 走马灯图片
     */
    private String image;

    /**
     * 产品名称
     */
    private String productName;
}
