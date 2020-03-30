package pers.yurwisher.dota2.system.pojo.to;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author yq
 * @date 2019-10-30 16:02:49
 * @description 附件 To
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AttachmentTo implements Serializable {
    private static final long serialVersionUID = -4584683040550855553L;
    private String fileType;
    private String fileName;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime uploadDate;
    private String uploadMen;
    private String fileAddress;
    private Long id;
    private String remark;
}
