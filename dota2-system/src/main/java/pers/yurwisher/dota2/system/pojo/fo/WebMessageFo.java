package pers.yurwisher.dota2.system.pojo.fo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author yq
 * @date 2019-08-15 17:07:13
 * @description 站内私信 Fo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WebMessageFo implements Serializable {

    private static final long serialVersionUID = -3359643503233365964L;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 消息接收人
     */
    private Long receiverId;
}
