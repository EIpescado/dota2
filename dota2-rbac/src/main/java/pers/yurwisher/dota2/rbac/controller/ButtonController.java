package pers.yurwisher.dota2.rbac.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.yurwisher.dota2.rbac.pojo.fo.ButtonFo;
import pers.yurwisher.dota2.rbac.service.IButtonService;
import pers.yurwisher.dota2.common.base.BaseController;
import pers.yurwisher.wisp.wrapper.R;

/**
 * @author yq
 * @date 2019-07-11 16:39:42
 * @description 按钮
 * @since V1.0.0
 */
@RestController
@RequestMapping("/button")
public class ButtonController extends BaseController {
    private IButtonService buttonService;

    public ButtonController(IButtonService buttonService) {
        this.buttonService = buttonService;
    }

    @PostMapping
    public R create(@RequestBody ButtonFo fo){
        buttonService.create(fo);
        return R.ok();
    }

    @PostMapping("{id}")
    public R update(@PathVariable(name = "id")Long id, @RequestBody ButtonFo fo){
        buttonService.update(id,fo);
        return R.ok();
    }

    @GetMapping("{id}")
    public R get(@PathVariable(name = "id")Long id){
        return R.ok(buttonService.get(id));
    }

    @PostMapping("/delete/{id}")
    public R delete(@PathVariable(name = "id")Long id){
        buttonService.delete(id);
        return R.ok();
    }

}
