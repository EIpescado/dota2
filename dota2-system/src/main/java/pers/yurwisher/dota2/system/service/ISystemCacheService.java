package pers.yurwisher.dota2.system.service;

import pers.yurwisher.dota2.system.pojo.qo.SystemCacheQo;
import pers.yurwisher.wisp.wrapper.PageR;

/**
 * @author yq
 * @date 2019/08/14 15:48
 * @description 系统缓存管理
 * @since V1.0.0
 */
public interface ISystemCacheService {

    /**
     * 系统缓存列表
     * @param qo qo
     * @return 缓存
     */
    PageR list(SystemCacheQo qo);

    /**
     * 删除指定缓存
     * @param key 缓存key值
     */
    void delete(String key);

    /**
     * 清空所有缓存
     */
    void flushDb();
}
