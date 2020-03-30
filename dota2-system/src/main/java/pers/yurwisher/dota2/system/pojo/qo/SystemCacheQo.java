package pers.yurwisher.dota2.system.pojo.qo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.yurwisher.dota2.common.wrapper.PageQo;

/**
 * @author yq
 * @date 2019/08/14 15:48
 * @description 系统缓存
 * @since V1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SystemCacheQo extends PageQo {
    private static final long serialVersionUID = 1575280207692529905L;

    private String key;

}
