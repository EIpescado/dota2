package pers.yurwisher.dota2.common.utils;

import pers.yurwisher.dota2.common.constant.cache.RBACCacheConstant;
import pers.yurwisher.wisp.constants.SymbolConstants;

/**
 * @author yq
 * @date 2018/11/09 15:01
 * @description redis key
 * @since V1.0.0
 */
public interface RedisKey {

    /**
     * 获取key ,存在集合中 形如 a::b,方便统一管理
     * @param prefix 前缀
     * @param suffix 后缀
     * @return a::b
     */
    static String generateKey(String prefix, String suffix){
        StringBuilder sb = new StringBuilder(prefix);
        sb.append(SymbolConstants.DOUBLE_COLON).append(suffix);
        return sb.toString();
    }

    /**
     * 生成验证码redis key
     * @param uuid  验证码的uuid
     * @return key
     */
    static String generateVerifyCodeKey(String uuid){
        return generateKey(RBACCacheConstant.VERIFY_CODE,uuid);
    }

    /**
     * 生成找回密码时redis key
     * @param uuid  用户手机号
     * @return key
     */
    static String generateRetrievePasswordCodeKey(String uuid){
        return generateKey(RBACCacheConstant.RETRIEVE_PASSWORD_PHONE_CODE,uuid);
    }

    /**
     * 生成找回密码操作有效期redis key
     * @param phone  用户手机号
     * @return key
     */
    static String generateRetrievePasswordPeriodOfValidityKey(String phone){
        return generateKey(RBACCacheConstant.RETRIEVE_PASSWORD_PERIOD_OF_VALIDITY,phone);
    }

    /**
     * 生成注册时redis key
     * @param phone  注册手机号
     * @return key
     */
    static String generateRegisterCodeKey(String phone){
        return generateKey(RBACCacheConstant.REGISTER_PHONE_CODE,phone);
    }
}
