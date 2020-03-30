package pers.yurwisher.dota2.system.pojo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yq
 * @date 2019-08-23 10:23:01
 * @description 消息模版 To
 * @since V1.0.0
 */
@Data
public class MessageTemplateVo implements Serializable {
    private static final long serialVersionUID = 76523005015755958L;
    private String code;
    private String name;
    private String template;
    private Boolean whetherNeedFormat;
    /**
     * 消息模版类别
     */
    private String type;
}
