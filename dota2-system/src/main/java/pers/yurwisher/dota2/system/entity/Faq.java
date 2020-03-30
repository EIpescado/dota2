package pers.yurwisher.dota2.system.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.yurwisher.dota2.common.base.BaseEntity;

/**
 * @author yq
 * @date 2019/10/15 11:29
 * @description FAQ 常见问题
 * @since V1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Faq extends BaseEntity {

    /**
     * 问题
     */
    private String question;
    /**
     * 答案
     */
    private String answer;

    /**
     * 归类
     */
    private String type;

    /**
     * 序号
     */
    private Integer sort;
}
