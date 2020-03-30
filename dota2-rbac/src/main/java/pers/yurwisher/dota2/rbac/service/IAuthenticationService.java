package pers.yurwisher.dota2.rbac.service;

import pers.yurwisher.dota2.common.enums.ValidCodeTypeEnum;
import pers.yurwisher.dota2.common.wrapper.JWTUser;
import pers.yurwisher.dota2.common.wrapper.ValidCode;
import pers.yurwisher.dota2.rbac.pojo.fo.LoginParams;
import pers.yurwisher.dota2.rbac.pojo.fo.RetrievePasswordFo;
import pers.yurwisher.dota2.rbac.pojo.fo.SystemUserRegisterFo;

/**
 * @author yq
 * @date 2019/07/18 14:43
 * @description 权限校验
 * @since V1.0.0
 */
public interface IAuthenticationService {

    /**
     * 注册
     * @param fo 注册
     * @return token
     */
    String register(SystemUserRegisterFo fo);

    /**
     * 登录
     * @param loginParams 参数
     * @return token字符串
     */
    String login(LoginParams loginParams);

    /**
     * 生成验证码
     * @return 验证码
     */
    ValidCode validCode();

    /**
     * 找回密码 step1 检验帐号是否存在,图片验证码是否正确
     * @param fo fo
     */
    void retrievePasswordStep1(RetrievePasswordFo fo);

    /**
     * 找回密码 step2 检验短信验证码是否正确
     * @param fo fo
     */
    void retrievePasswordStep2(RetrievePasswordFo fo);

    /**
     * 找回密码 step3 设置新密码,附带短信,短信过期则本次所有操作失效,回到起点
     * @param fo fo
     */
    void retrievePasswordStep3(RetrievePasswordFo fo);

    /**
     * 发送短信验证码
     * @param phone 手机号
     * @param type 验证码类型
     */
    void sendMessageAuthCode(String phone, ValidCodeTypeEnum type);

}
