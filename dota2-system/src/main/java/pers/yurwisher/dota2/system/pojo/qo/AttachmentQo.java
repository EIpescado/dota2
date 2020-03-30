package pers.yurwisher.dota2.system.pojo.qo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import pers.yurwisher.dota2.common.wrapper.PageQo;

/**
 * @author yq
 * @date 2019-10-30 16:02:49
 * @description 附件 Qo
 * @since V1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AttachmentQo extends PageQo {
    private static final long serialVersionUID = 1136903033711055676L;
    private String fileName;
    private String remark;
}
