package pers.yurwisher.dota2.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.yurwisher.dota2.common.base.BaseController;
import pers.yurwisher.dota2.system.pojo.fo.SystemConfigFo;
import pers.yurwisher.dota2.system.pojo.qo.SystemConfigQo;
import pers.yurwisher.dota2.system.service.ISystemConfigService;
import pers.yurwisher.wisp.wrapper.R;

/**
 * @author yq
 * @date 2019/08/14 13:59
 * @description 系统配置
 * @since V1.0.0
 */
@RestController
@RequestMapping("/systemConfig")
public class SystemConfigController extends BaseController {

    private ISystemConfigService systemConfigService;

    public SystemConfigController(ISystemConfigService systemConfigService) {
        this.systemConfigService = systemConfigService;
    }

    @GetMapping
    public R list(@ModelAttribute SystemConfigQo qo){
        return R.ok(systemConfigService.list(qo));
    }


    @PostMapping
    public R create(@RequestBody SystemConfigFo fo){
        systemConfigService.create(fo);
        return R.ok();
    }

    @PostMapping("{id}")
    public R update(@RequestBody SystemConfigFo fo, @PathVariable Long id){
        systemConfigService.update(id,fo);
        return R.ok();
    }

    @GetMapping("{id}")
    public R get(@PathVariable(name = "id")Long id){
        return R.ok(systemConfigService.get(id));
    }

    @PostMapping("byCode")
    public R updateByCode(@RequestBody SystemConfigFo fo){
        systemConfigService.updateByCode(fo.getCode(),fo.getVal());
        return R.ok();
    }

    @GetMapping("byCode")
    public R getByCode(@RequestParam String code){
        return R.ok( systemConfigService.getValByCode(code));
    }
}
