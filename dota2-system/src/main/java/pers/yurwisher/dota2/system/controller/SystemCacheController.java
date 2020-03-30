package pers.yurwisher.dota2.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.yurwisher.dota2.common.base.BaseController;
import pers.yurwisher.dota2.system.pojo.fo.SystemCacheFo;
import pers.yurwisher.dota2.system.pojo.qo.SystemCacheQo;
import pers.yurwisher.dota2.system.service.ISystemCacheService;
import pers.yurwisher.wisp.wrapper.R;

/**
 * @author yq
 * @date 2019/08/14 13:59
 * @description 系统配置
 * @since V1.0.0
 */
@RestController
@RequestMapping("/systemCache")
public class SystemCacheController extends BaseController {

    private ISystemCacheService systemCacheService;

    public SystemCacheController(ISystemCacheService systemCacheService) {
        this.systemCacheService = systemCacheService;
    }

    @GetMapping
    public R list(@ModelAttribute SystemCacheQo qo){
        return R.ok(systemCacheService.list(qo));
    }

    @PostMapping("/delete")
    public R delete(@RequestBody SystemCacheFo fo){
        systemCacheService.delete(fo.getKey());
        return R.ok();
    }

    @PostMapping("/flushDb")
    public R flushDb(){
        systemCacheService.flushDb();
        return R.ok();
    }
}
