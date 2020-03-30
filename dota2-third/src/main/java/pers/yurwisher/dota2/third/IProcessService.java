package pers.yurwisher.dota2.third;

import pers.yurwisher.dota2.common.enums.ValidCodeTypeEnum;
import pers.yurwisher.dota2.common.wrapper.ValidCode;

/**
 * @author yq
 * @date 2019/11/20 17:47
 * @description 异步执行
 * @since V1.0.0
 */
public interface IProcessService {

    /**
     * 异步发送短信
     * @param message 短信内容
     * @param phone 手机号
     */
    void sendMessage(String message, String phone);

    /**
     * 注册短信
     *
     * @param phone          手机号
     * @param timeoutMinute  验证码有效期,单位分钟
     */
    void sendRegisterMessage(String phone, int timeoutMinute);

    /**
     * 找回密码短信
     * @param phone 手机号
     * @param timeoutMinute 验证码有效期,单位分钟
     */
    void sendRetrievePasswordMessage(String phone,int timeoutMinute) ;


    /**
     * 验证 手机短信验证码
     * @param phone 手机号
     * @param phoneValidCode 短信验证码
     * @param type 短信验证码类型
     */
    void checkPhoneValidCode(String phone, String phoneValidCode, ValidCodeTypeEnum type);

    /**
     * 生成图片验证码
     * @param length 验证码长度
     * @param timeoutMinute 验证码有效期
     * @return 验证码
     */
    ValidCode validCode(int length,int timeoutMinute);

    /**
     * 校验验证码
     * @param validCode 验证码值
     * @param uuid 验证码id
     */
    void checkValidCode(String validCode,String uuid);
}
