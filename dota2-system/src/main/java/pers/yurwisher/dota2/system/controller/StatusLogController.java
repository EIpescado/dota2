package pers.yurwisher.dota2.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.yurwisher.dota2.common.base.BaseController;
import pers.yurwisher.dota2.system.pojo.qo.StatusLogQo;
import pers.yurwisher.dota2.system.service.IStatusLogService;
import pers.yurwisher.wisp.wrapper.R;

/**
 * @author yq
 * @date 2019/11/11 22:46
 * @description 状态日志
 * @since V1.0.0
 */
@RestController
@RequestMapping("/statusLog")
public class StatusLogController extends BaseController {

    private IStatusLogService statusLogService;

    public StatusLogController(IStatusLogService statusLogService) {
        this.statusLogService = statusLogService;
    }

    @GetMapping
    public R list(@ModelAttribute StatusLogQo qo){
        return R.ok(statusLogService.list(qo));
    }
}
