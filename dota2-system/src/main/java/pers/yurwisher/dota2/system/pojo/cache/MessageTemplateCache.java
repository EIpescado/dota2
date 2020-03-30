package pers.yurwisher.dota2.system.pojo.cache;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author yq
 * @date 2019/08/26 10:29
 * @description 消息模版缓存
 * @since V1.0.0
 */
@Data
public class MessageTemplateCache {

    private Long id;
    private String templateName;
    private String template;
    private Boolean whetherNeedFormat;
    private LocalDateTime lastUpdated;
}
