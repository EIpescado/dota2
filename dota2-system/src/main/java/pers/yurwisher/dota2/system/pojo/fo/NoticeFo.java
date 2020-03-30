package pers.yurwisher.dota2.system.pojo.fo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author yq
 * @date 2019-08-15 17:10:44
 * @description 消息 Fo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class NoticeFo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;
    private String content;
}
