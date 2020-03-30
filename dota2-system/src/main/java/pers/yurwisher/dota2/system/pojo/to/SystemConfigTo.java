package pers.yurwisher.dota2.system.pojo.to;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author yq
 * @date 2018/12/05 09:08
 * @description 系统配置
 * @since V1.0.0
 */
@Data
public class SystemConfigTo {
    private static final long serialVersionUID = 6008665086561814559L;

    private Long id;
    /**
     * 配置名称
     */
    private String name;

    /**
     * 配置编码
     */
    private String code;

    /**
     * 配置值
     */
    private String val;

    /**
     * 创建日期
     */
    private LocalDateTime dateCreated;

    /**
     * 最后更新日期
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastUpdated;
}
