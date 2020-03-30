package pers.yurwisher.dota2.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.yurwisher.dota2.common.base.BaseController;
import pers.yurwisher.dota2.system.pojo.fo.EnterprisePortalInfoFo;
import pers.yurwisher.dota2.system.pojo.qo.EnterprisePortalInfoQo;
import pers.yurwisher.dota2.system.service.IEnterprisePortalInfoService;
import pers.yurwisher.wisp.wrapper.R;

/**
 * @author yq
 * @date 2019-10-31 09:19:05
 * @description 企业门户信息配置
 * @since V1.0.0
 */
@RestController
@RequestMapping("/enterprisePortalInfo")
public class EnterprisePortalInfoController extends BaseController{
    private IEnterprisePortalInfoService enterprisePortalInfoService;

    public EnterprisePortalInfoController(IEnterprisePortalInfoService enterprisePortalInfoService) {
        this.enterprisePortalInfoService = enterprisePortalInfoService;
    }

    @GetMapping
    public R list(@ModelAttribute EnterprisePortalInfoQo qo){
        return R.ok(enterprisePortalInfoService.list(qo));
    }

    @PostMapping("{id}")
    public R update(@PathVariable Long id, @RequestBody EnterprisePortalInfoFo fo){
        enterprisePortalInfoService.update(id,fo);
        return R.ok();
    }

    @PostMapping
    public R create(@RequestBody EnterprisePortalInfoFo fo){
        enterprisePortalInfoService.create(fo);
        return R.ok();
    }

    @PostMapping("/activate/{id}")
    public R activate(@PathVariable Long id){
        enterprisePortalInfoService.activate(id);
        return R.ok();
    }
}
