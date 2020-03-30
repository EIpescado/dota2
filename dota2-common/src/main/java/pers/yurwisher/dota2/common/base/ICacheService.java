package pers.yurwisher.dota2.common.base;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author yq
 * @date 2019/07/18 15:01
 * @description cache service
 * @since V1.0.0
 */
public interface ICacheService {

    void put(String key, Object value);

    void put(String key, Object value, long times, TimeUnit unit);

    void put(String hash, String key, Object value);

    Object get(String key);

    Object get(String hash, String key);

    void delete(String key);

    void delete(String hash, String key);

    Set<String> keys(String pattern);

    Long increment(String key, long value);

    void flushDb();

    Boolean expire(String key, long timeout, TimeUnit unit);
}
