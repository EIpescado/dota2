package pers.yurwisher.dota2.third.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pers.yurwisher.dota2.common.base.ICacheService;
import pers.yurwisher.dota2.common.constant.cache.ThirdCacheConstant;
import pers.yurwisher.dota2.common.enums.ValidCodeTypeEnum;
import pers.yurwisher.dota2.common.enums.tip.RBACCustomTipEnum;
import pers.yurwisher.dota2.common.enums.tip.ThirdCustomTipEnum;
import pers.yurwisher.dota2.common.exception.RBACException;
import pers.yurwisher.dota2.common.exception.ThirdException;
import pers.yurwisher.dota2.common.utils.RedisKey;
import pers.yurwisher.dota2.common.utils.Utils;
import pers.yurwisher.dota2.common.wrapper.ValidCode;
import pers.yurwisher.dota2.third.IProcessService;
import pers.yurwisher.dota2.third.MessageSender;
import pers.yurwisher.juggernaut.support.DefaultWorkGroup;
import pers.yurwisher.juggernaut.support.IWorkGroup;
import pers.yurwisher.wisp.utils.Asserts;
import pers.yurwisher.wisp.utils.CodeUtils;
import pers.yurwisher.wisp.utils.StringUtils;
import pers.yurwisher.wisp.utils.VerifyCodeUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author yq
 * @date 2019/11/20 17:47
 * @description 异步执行实现
 * @since V1.0.0
 */
@Service
@Slf4j
public class DefaultProcessServiceImpl implements IProcessService {

    private MessageSender messageSender;
    private ICacheService cacheService;
    /**发送短信组*/
    private IWorkGroup<JSONObject> phoneMessageSendGroup ;

    @Value("${yurwisher.dota2.register-content}")
    private String registerContent;
    @Value("${yurwisher.dota2.retrieve-password-content}")
    private String retrievePasswordContent;
    @Value("${yurwisher.dota2.valid-code-width}")
    private Integer validCodeWidth;
    @Value("${yurwisher.dota2.valid-code-height}")
    private Integer validCodeHeight;

    public DefaultProcessServiceImpl(MessageSender messageSender, ICacheService cacheService) {
        this.messageSender = messageSender;
        this.cacheService = cacheService;
        this.phoneMessageSendGroup = new DefaultWorkGroup<>(2, 512, "phone-message-sender-", 1);
        phoneMessageSendGroup.setWork(workTask ->{
            JSONObject json = workTask.getTask();
            messageSender.sendMessage(json.getString("message"),json.getString("phone"));
        });
        phoneMessageSendGroup.reGroup();
    }

    @Override
    public void sendMessage(String message,String phone){
        //限制发送次数
        String key = RedisKey.generateKey(ThirdCacheConstant.PHONE_SEND_MESSAGE_LIMIT,phone);
        Long value = cacheService.increment(key,1L);
        //单个手机号10分钟内只可发送3次
        if(value <= 3L) {
            if (value == 1L) {
                cacheService.expire(key, 10, TimeUnit.MINUTES);
            }
            phoneMessageSendGroup.accept(new JSONObject().fluentPut("message",message).fluentPut("phone",phone));
        }else{
            log.info("手机 [{}] ,10分钟内发送短信次数过多,当前计数: [{}]",phone,value);
            throw new ThirdException(ThirdCustomTipEnum.SEND_MESSAGE_TOO_MUCH);
        }
    }

    @Override
    public void sendRegisterMessage(String phone,int timeoutMinute) {
        String phoneValidCode = this.generatePhoneValidCode();
        log.info("发送注册验证码:[{}] 到手机:[{}]",phoneValidCode,phone);
        cacheService.put(RedisKey.generateRegisterCodeKey(phone), phoneValidCode, timeoutMinute , TimeUnit.MINUTES);
        this.sendMessage(String.format(registerContent, phoneValidCode),phone);
    }

    @Override
    public void sendRetrievePasswordMessage(String phone,int timeoutMinute) {
        String phoneValidCode = this.generatePhoneValidCode();
        log.info("发送重置密码验证码:[{}] 到手机:[{}]",phoneValidCode,phone);
        cacheService.put(RedisKey.generateRetrievePasswordCodeKey(phone), phoneValidCode, timeoutMinute , TimeUnit.MINUTES);
        this.sendMessage(String.format(retrievePasswordContent, phoneValidCode),phone);
    }

    private String generatePhoneValidCode(){
        //生成6位验证码
        return  VerifyCodeUtils.generateNumberVerifyCode(6);
    }

    @Override
    public void checkPhoneValidCode(String phone, String phoneValidCode, ValidCodeTypeEnum type) {
        //校验验证码
        if(StringUtils.isEmpty(phone) || StringUtils.isEmpty(phoneValidCode)){
            throw new RBACException(RBACCustomTipEnum.VALID_CODE_ERROR);
        }
        String validCodeKey = null;
        switch (type){
            //注册短信
            case R:
                validCodeKey = RedisKey.generateRegisterCodeKey(phone);
                break;
            //找回密码短信
            case RP:
                validCodeKey = RedisKey.generateRetrievePasswordCodeKey(phone);
                break;
            default:
        }
        Asserts.notEmpty(validCodeKey);
        Object codeInRedis = cacheService.get(validCodeKey);
        if(codeInRedis == null){
            throw new RBACException(RBACCustomTipEnum.VALID_CODE_EXPIRED);
        }
        //验证码错误
        if (!phoneValidCode.equalsIgnoreCase(codeInRedis.toString())){
            throw new RBACException(RBACCustomTipEnum.VALID_CODE_ERROR);
        }
        //移除验证码
        cacheService.delete(validCodeKey);
    }

    @Override
    public ValidCode validCode(int length, int timeoutMinute) {
        //验证码
        String vCode = VerifyCodeUtils.generate(length);
        String uuid = Utils.uuid();
        // 生成图片
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {
            VerifyCodeUtils.outputImage(validCodeWidth, validCodeHeight, stream, vCode);
            //存入redis,5分钟内有效
            cacheService.put(RedisKey.generateVerifyCodeKey(uuid), vCode, timeoutMinute , TimeUnit.MINUTES);
            return new ValidCode(CodeUtils.encryptBASE64(stream.toByteArray()), uuid);
        } catch (IOException e) {
            throw new RBACException(RBACCustomTipEnum.GENERATE_VALID_CODE_ERROR);
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                log.error("生成验证码关闭流失败",e);
            }
        }
    }

    @Override
    public void checkValidCode(String validCode, String uuid) {
        //校验验证码
        if(StringUtils.isEmpty(validCode) || StringUtils.isEmpty(uuid)){
            throw new RBACException(RBACCustomTipEnum.VALID_CODE_ERROR);
        }
        String validCodeKey = null;
        try{
            validCodeKey = RedisKey.generateVerifyCodeKey(uuid);
            String code = (String) cacheService.get(validCodeKey);
            //验证码过期
            if(StringUtils.isEmpty(code)){
                throw new RBACException(RBACCustomTipEnum.VALID_CODE_EXPIRED);
            }
            //验证码错误
            if (!code.equalsIgnoreCase(validCode)){
                throw new RBACException(RBACCustomTipEnum.VALID_CODE_ERROR);
            }
        }finally {
            if(StringUtils.isNotEmpty(validCodeKey)){
                //移除验证码
                cacheService.delete(validCodeKey);
            }
        }
    }
}
