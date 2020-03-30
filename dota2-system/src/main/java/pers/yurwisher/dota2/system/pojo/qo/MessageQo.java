package pers.yurwisher.dota2.system.pojo.qo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import pers.yurwisher.dota2.common.wrapper.PageQo;

/**
 * @author yq
 * @date 2019-08-15 17:07:13
 * @description 消息 Qo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class MessageQo extends PageQo {
    private static final long serialVersionUID = -1925332388854826445L;

    /**
     * 和当前用户交流的用户ID
     */
    private Long talkUserId;
}
