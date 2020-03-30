package pers.yurwisher.dota2.system.pojo.to;

import lombok.Data;

/**
 * @author yq
 * @date 2019/08/14 15:51
 * @description 系统缓存列表
 * @since V1.0.0
 */
@Data
public class SystemCacheTo  {

    private String key;
    private String value;

    public SystemCacheTo(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
