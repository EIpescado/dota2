package pers.yurwisher.dota2.rbac.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.yurwisher.dota2.common.base.ICacheService;
import pers.yurwisher.dota2.common.constant.SystemConstant;
import pers.yurwisher.dota2.common.enums.UserStatusEnum;
import pers.yurwisher.dota2.common.enums.ValidCodeTypeEnum;
import pers.yurwisher.dota2.common.enums.tip.RBACCustomTipEnum;
import pers.yurwisher.dota2.common.exception.RBACException;
import pers.yurwisher.dota2.common.utils.RedisKey;
import pers.yurwisher.dota2.common.utils.Utils;
import pers.yurwisher.dota2.common.wrapper.TokenPlus;
import pers.yurwisher.dota2.common.wrapper.ValidCode;
import pers.yurwisher.dota2.rbac.entity.SystemUser;
import pers.yurwisher.dota2.rbac.pojo.fo.LoginParams;
import pers.yurwisher.dota2.rbac.pojo.fo.RetrievePasswordFo;
import pers.yurwisher.dota2.rbac.pojo.fo.SystemUserRegisterFo;
import pers.yurwisher.dota2.rbac.service.IAuthenticationService;
import pers.yurwisher.dota2.rbac.service.ISystemRoleService;
import pers.yurwisher.dota2.rbac.service.ISystemUserService;
import pers.yurwisher.dota2.third.IProcessService;
import pers.yurwisher.token.ITokenService;
import pers.yurwisher.wisp.utils.Asserts;

import java.time.ZoneOffset;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author yq
 * @date 2019/07/18 14:45
 * @description Authentication service
 * @since V1.0.0
 */
@Service
@Slf4j
public class AuthenticationServiceImpl implements IAuthenticationService {


    private ISystemUserService systemUserService;
    private ISystemRoleService systemRoleService;
    private ITokenService<TokenPlus> tokenService;
    private ICacheService cacheService;
    private IProcessService processService;

    public AuthenticationServiceImpl(ISystemUserService systemUserService, ISystemRoleService systemRoleService, ITokenService<TokenPlus> tokenService,
                                     ICacheService cacheService, IProcessService processService) {
        this.systemUserService = systemUserService;
        this.systemRoleService = systemRoleService;
        this.tokenService = tokenService;
        this.cacheService = cacheService;
        this.processService = processService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String register(SystemUserRegisterFo fo) {
        SystemUser user =  systemUserService.create(fo);
        //生成token
        return this.generateToken(user, Collections.singletonList(SystemConstant.REGISTER_USER_DEFAULT_ROLE_CODE));
    }

    @Override
    public String login(LoginParams params) {
        Asserts.notEmpty(params.getUsername());
        Asserts.notEmpty(params.getPassword());

        //校验验证码
        processService.checkValidCode(params.getValidCode(),params.getUuid());

        //验证用户
        SystemUser user = systemUserService.findByUsername(params.getUsername());
        if (user == null) {
            throw new RBACException(RBACCustomTipEnum.USER_NAME_OR_PASSWORD_ERROR);
        }

        //帐号已被禁用
        if (user.getStatus() == UserStatusEnum.DISABLED) {
            throw new RBACException(RBACCustomTipEnum.USER_DISABLED);
        }

        //校验密码
        if (!user.getPassword().equals(Utils.encryptPassword(params.getPassword()))) {
            throw new RBACException(RBACCustomTipEnum.USER_NAME_OR_PASSWORD_ERROR);
        }
        return this.generateToken(user,systemRoleService.getRoles(user.getId()));
    }

    @Override
    public ValidCode validCode() {
        return processService.validCode(4,5);
    }

    @Override
    public void retrievePasswordStep1(RetrievePasswordFo fo) {
        //校验验证码
        processService.checkValidCode(fo.getValidCode(),fo.getUuid());
        //帐号不存在
        if(!systemUserService.userExist(fo.getPhone())){
            throw new RBACException(RBACCustomTipEnum.USER_NAME_NOT_EXIST);
        }
    }

    @Override
    public void retrievePasswordStep2(RetrievePasswordFo fo) {
        //生成id,限制找回密码时效 16分钟
        cacheService.put(RedisKey.generateRetrievePasswordPeriodOfValidityKey(fo.getPhone()),true, 16 , TimeUnit.MINUTES);
        //校验短信验证码
        processService.checkPhoneValidCode(fo.getPhone(),fo.getPhoneValidCode(), ValidCodeTypeEnum.RP);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void retrievePasswordStep3(RetrievePasswordFo fo) {
        //校验2次密码是否一致
        if(!fo.getPassword().equals(fo.getReEnterPassword())){
            throw new RBACException(RBACCustomTipEnum.TWO_PASSWORD_IN_CONFORMITY);
        }
        //校验帐号
        if(!systemUserService.userExist(fo.getPhone())){
            throw new RBACException(RBACCustomTipEnum.USER_NAME_NOT_EXIST);
        }
        //校验找回时效
        String key = RedisKey.generateRetrievePasswordPeriodOfValidityKey(fo.getPhone());
        Object value = cacheService.get(key);
        //操作已失效
        if(value == null){
            throw new RBACException(RBACCustomTipEnum.RETRIEVE_PASSWORD_EXPIRED);
        }
        //重置密码
        systemUserService.resetPassword(fo.getPhone(),fo.getPassword());
    }

    @Override
    public void sendMessageAuthCode(String phone, ValidCodeTypeEnum type) {
        Asserts.notEmpty(phone);
        switch (type){
            //注册短信
            case R:
                if(systemUserService.userExist(phone)){
                    throw new RBACException(RBACCustomTipEnum.PHONE_HAVE_BEEN_USED);
                }
                processService.sendRegisterMessage(phone,5);
                break;
            //找回密码短信
            case RP:
                if(!systemUserService.userExist(phone)){
                    throw new RBACException(RBACCustomTipEnum.USER_NAME_NOT_EXIST);
                }
                processService.sendRetrievePasswordMessage(phone,5);
                break;
            default:
        }
    }

    /**
     * 生成token
     * @param user 用户
     * @param roles 角色
     * @return token string
     */
    private String generateToken(SystemUser user, List<String> roles){
        TokenPlus plus = new TokenPlus();
        plus.setId(user.getId());
        plus.setUserName(user.getUsername());
        plus.setRoles(roles);
        //东八区
        plus.setLastUpdatePassword(user.getLastPasswordResetDate() != null ? user.getLastPasswordResetDate().toEpochSecond(ZoneOffset.of("+8")) : null);
        return tokenService.generateToken(plus);
    }

}
