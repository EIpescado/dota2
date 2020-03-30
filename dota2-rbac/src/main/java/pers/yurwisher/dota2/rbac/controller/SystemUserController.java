package pers.yurwisher.dota2.rbac.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.yurwisher.dota2.common.base.BaseController;
import pers.yurwisher.dota2.common.wrapper.JWTUser;
import pers.yurwisher.dota2.rbac.pojo.fo.ResetPasswordFo;
import pers.yurwisher.dota2.rbac.pojo.qo.SystemUserQo;
import pers.yurwisher.dota2.rbac.service.ISystemUserService;
import pers.yurwisher.wisp.wrapper.R;

/**
 * @author yq
 * @date 2019-07-10 16:59:09
 * @description 用户
 * @since V1.0.0
 */
@RestController
@RequestMapping("/user")
public class SystemUserController extends BaseController {
    private ISystemUserService systemUserService;

    public SystemUserController(ISystemUserService systemUserService) {
        this.systemUserService = systemUserService;
    }

    /**用户列表*/
    @GetMapping("info")
    public R info(){
        return R.ok(systemUserService.info(JWTUser.currentUserId()));
    }

    /**禁用用户*/
    @PostMapping("/disable/{id}")
    public R disable(@PathVariable(name = "id")Long id){
        systemUserService.disable(id);
        return R.ok();
    }

    /**用户列表*/
    @GetMapping
    public R list(@ModelAttribute SystemUserQo qo){
        return R.ok(systemUserService.list(qo));
    }

    /**修改密码*/
    @PostMapping("changePassword")
    public R changePassword(@RequestBody ResetPasswordFo resetPasswordFo){
        systemUserService.changePassword(resetPasswordFo);
        return R.ok();
    }

    /**用户状态下拉框*/
    @GetMapping("statusSelect")
    public R userStatusSelect(){
        return R.ok(systemUserService.userStatusSelect());
    }

}
