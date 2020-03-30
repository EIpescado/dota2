package pers.yurwisher.dota2.system.pojo.vo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author yq
 * @date 2019/11/07 10:05
 * @description 信息详情
 * @since V1.0.0
 */
@Data
public class MessageVo implements Serializable {
    private static final long serialVersionUID = -4192438330654229029L;

    private String title;
    private String content;
    private LocalDateTime dateCreated;
}
