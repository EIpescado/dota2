package pers.yurwisher.dota2.system.pojo.to;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author yq
 * @date 2019/10/31 11:27
 * @description 企业门户配置to
 * @since V1.0.0
 */
@Data
public class EnterprisePortalInfoTo implements Serializable {

    private static final long serialVersionUID = -6931603537797641219L;
    private Long id;

    /**json值*/
    private String content;
    /**
     * 是否已激活
     */
    private Boolean activated;
    /**创建时间*/
    private LocalDateTime dateCreated;
    /**修改时间*/
    private LocalDateTime lastUpdated;

    private String remark;
}
