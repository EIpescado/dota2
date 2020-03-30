package pers.yurwisher.dota2.common.constant.cache;

import static pers.yurwisher.dota2.common.constant.SystemConstant.CACHE_SYSTEM_PREFIX;

/**
 * @author yq
 * @date 2019/07/29 10:07
 * @description cache name 常量,标识 key的过期时间,
 *                此为一组,即形如 NEVER_EXPIRE_CACHE::001,
 *                               NEVER_EXPIRE_CACHE::002
 * @since V1.0.0
 */
public interface SystemCacheConstant {

    /**
     * 字典下拉框
     */
    String DICT_SELECT = CACHE_SYSTEM_PREFIX + "DICT_SELECT";

    /**
     * 消息模版类型编码-模版映射
     */
    String MESSAGE_TEMPLATE_TYPE_CODE_MESSAGE_TEMPLATE= CACHE_SYSTEM_PREFIX + "MESSAGE_TEMPLATE_TYPE_CODE_MESSAGE_TEMPLATE";

    /**
     * 系统配置编码值映射
     */
    String SYSTEM_CONFIG_CODE_VALUE = CACHE_SYSTEM_PREFIX + "SYSTEM_CONFIG_CODE_VALUE";

    /**门户信息配置*/
    String ENTERPRISE_PORTAL_INFO = CACHE_SYSTEM_PREFIX + "ENTERPRISE_PORTAL_INFO";

}
