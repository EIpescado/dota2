package pers.yurwisher.dota2.system.pojo.fo;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author yq
 * @date 2019-08-15 17:07:13
 * @description 系统消息 Fo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SystemMessageFo implements Serializable {

    private static final long serialVersionUID = -5933901029432200376L;
    private Long receiverId;
    /**
     * 消息模版类型
     */
    private String messageTemplateType;
    /**
     * 模版编码
     */
    private String templateCode;
    /**
     * 模版JSON参数
     */
    private JSONObject params;

}
