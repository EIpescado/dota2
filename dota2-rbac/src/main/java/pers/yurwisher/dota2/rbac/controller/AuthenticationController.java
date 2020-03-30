package pers.yurwisher.dota2.rbac.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.yurwisher.dota2.common.base.BaseController;
import pers.yurwisher.dota2.common.enums.ValidCodeTypeEnum;
import pers.yurwisher.dota2.rbac.pojo.fo.LoginParams;
import pers.yurwisher.dota2.rbac.pojo.fo.RetrievePasswordFo;
import pers.yurwisher.dota2.rbac.pojo.fo.SystemUserRegisterFo;
import pers.yurwisher.dota2.rbac.service.IAuthenticationService;
import pers.yurwisher.wisp.wrapper.R;

/**
 * @author yq
 * @date 2019/07/12 11:09
 * @description 认证 controller
 * @since V1.0.0
 */
@RestController
@RequestMapping("/auth")
public class AuthenticationController extends BaseController {

    private IAuthenticationService authenticationService;

    public AuthenticationController(IAuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    /**登录*/
    @PostMapping("/login")
    public R login(@RequestBody LoginParams params){
        return R.ok(authenticationService.login(params));
    }

    /**验证码*/
    @GetMapping("/validCode")
    public R validCode(){
        return R.ok(authenticationService.validCode());
    }

    /**找回密码step1*/
    @PostMapping("/retrievePasswordStep1")
    public R retrievePasswordStep1(@RequestBody RetrievePasswordFo fo){
        authenticationService.retrievePasswordStep1(fo);
        return R.ok();
    }

    /**找回密码step2*/
    @PostMapping("/retrievePasswordStep2")
    public R retrievePasswordStep2(@RequestBody RetrievePasswordFo fo){
        authenticationService.retrievePasswordStep2(fo);
        return R.ok();
    }

    /**找回密码step3*/
    @PostMapping("/retrievePasswordStep3")
    public R retrievePasswordStep3(@RequestBody RetrievePasswordFo fo){
        authenticationService.retrievePasswordStep3(fo);
        return R.ok();
    }

    /**发送短信验证码*/
    @GetMapping("/sendMessageAuthCode")
    public R sendMessageAuthCode(@RequestParam String phone,@RequestParam ValidCodeTypeEnum type){
        authenticationService.sendMessageAuthCode(phone,type);
        return R.ok();
    }

    /**注册用户*/
    @PostMapping("/register")
    public R register(@RequestBody SystemUserRegisterFo fo){
        return R.ok(authenticationService.register(fo));
    }
}
