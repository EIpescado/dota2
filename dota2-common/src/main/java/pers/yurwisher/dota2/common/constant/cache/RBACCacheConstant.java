package pers.yurwisher.dota2.common.constant.cache;


import static pers.yurwisher.dota2.common.constant.SystemConstant.CACHE_RBAC_PREFIX;

/**
 * @author yq
 * @date 2019/07/29 10:07
 * @description cache name 常量,标识 key的过期时间,
 *                此为一组,即形如 NEVER_EXPIRE_CACHE::001,
 *                               NEVER_EXPIRE_CACHE::002
 * @since V1.0.0
 */
public interface RBACCacheConstant {

    /**
     * 永不过期
     */
    String NEVER_EXPIRE_CACHE = CACHE_RBAC_PREFIX + "NEVER_EXPIRE_CACHE";

    /**
     * 用户菜单树
     */
    String USER_MENU_TREE = CACHE_RBAC_PREFIX +"USER_MENU_TREE";

    /**
     * 枚举下拉框
     */
    String SELECT = CACHE_RBAC_PREFIX + "SELECT";

    /**
     * 单个部门下的职位
     */
    String DEPARTMENT_JOB = CACHE_RBAC_PREFIX + "DEPARTMENT_JOB";

    /**
     * 自定义用户信息
     */
    String CUSTOM_USER_INFO = CACHE_RBAC_PREFIX + "CUSTOM_USER_INFO";

    /**
     * 用户角色
     */
    String USER_ROLE_CODE = CACHE_RBAC_PREFIX + "USER_ROLE_CODE";

    /**
     * 登录图片验证码
     */
    String VERIFY_CODE = CACHE_RBAC_PREFIX + "VERIFY_CODE";

    /**
     * 找回密码短信验证码验证码
     */
    String RETRIEVE_PASSWORD_PHONE_CODE = CACHE_RBAC_PREFIX + "RETRIEVE_PASSWORD_PHONE_CODE";

    /**
     * 找回密码操作有效期
     */
    String RETRIEVE_PASSWORD_PERIOD_OF_VALIDITY = CACHE_RBAC_PREFIX + "RETRIEVE_PASSWORD_PERIOD_OF_VALIDITY";

    /**
     * 注册短信验证码
     */
    String REGISTER_PHONE_CODE = CACHE_RBAC_PREFIX + "REGISTER_PHONE_CODE";

}
