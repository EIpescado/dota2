package pers.yurwisher.dota2.common.constant;

/**
 * 系统常量
 * @author yq
 */
public interface SystemConstant {

    /**RBAC 缓存前缀*/
    String CACHE_RBAC_PREFIX = "DOTA2_RBAC_";
    /**SYSTEM 缓存前缀*/
    String CACHE_SYSTEM_PREFIX = "DOTA2_SYSTEM_";
    /**THIRD 缓存前缀*/
    String CACHE_THIRD_PREFIX = "DOTA2_THIRD_";

    /**管理员用户ID*/
    Long ADMIN_USER_ID = 10000L;

    /**注册用户默认角色ID*/
    Long REGISTER_USER_DEFAULT_ROLE_ID = 1194257132794994690L;

    /**注册用户默认角色CODE*/
    String REGISTER_USER_DEFAULT_ROLE_CODE = "ROLE_REGISTER_USER";
}
