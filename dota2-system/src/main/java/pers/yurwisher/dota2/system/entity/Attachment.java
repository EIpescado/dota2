package pers.yurwisher.dota2.system.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.yurwisher.dota2.common.base.BaseEntity;

import java.time.LocalDateTime;

/**
 * @author yq
 * @date 2019/10/30 15:59
 * @description 附件
 * @since V1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Attachment extends BaseEntity {

    /**
     * 文件类型
     */
    private String fileType;
    /**
     * 文件原始名称
     */
    private String fileName;
    /**
     * 上传时间
     */
    private LocalDateTime uploadDate;
    /**
     * 上传用户ID
     */
    private Long uploadUserId;

    /**
     * 文件访问地址
     */
    private String fileAddress;

    /**
     * 备注
     */
    private String remark;
}
