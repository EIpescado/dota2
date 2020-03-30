package pers.yurwisher.dota2.common.constant.cache;

import static pers.yurwisher.dota2.common.constant.SystemConstant.CACHE_THIRD_PREFIX;

/**
 * @author yq
 * @date 2019/07/29 10:07
 * @description cache name 常量,标识 key的过期时间,
 *                此为一组,即形如 NEVER_EXPIRE_CACHE::001,
 *                               NEVER_EXPIRE_CACHE::002
 * @since V1.0.0
 */
public interface ThirdCacheConstant {

    /**手机短信推送限制*/
    String PHONE_SEND_MESSAGE_LIMIT = CACHE_THIRD_PREFIX + "PHONE_SEND_MESSAGE_LIMIT";

}
