package pers.yurwisher.dota2.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.yurwisher.dota2.common.base.BaseController;
import pers.yurwisher.dota2.system.pojo.fo.DictFo;
import pers.yurwisher.dota2.system.pojo.qo.DictQo;
import pers.yurwisher.dota2.system.service.IDictService;
import pers.yurwisher.wisp.wrapper.R;

/**
 * @author yq
 * @date 2019-10-14 13:55:36
 * @description 字典
 * @since V1.0.0
 */
@RestController
@RequestMapping("/dict")
public class DictController extends BaseController {
    private IDictService dictService;

    public DictController(IDictService dictService) {
        this.dictService = dictService;
    }

    @PostMapping
    public R create(@RequestBody DictFo fo){
        dictService.create(fo);
        return R.ok();
    }

    @PostMapping("{id}")
    public R update(@PathVariable(name = "id")Long id, @RequestBody DictFo fo){
        dictService.update(id,fo);
        return R.ok();
    }

    @GetMapping("{id}")
    public R get(@PathVariable(name = "id")Long id){
        return R.ok(dictService.get(id));
    }

    @PostMapping("/delete/{id}")
    public R delete(@PathVariable(name = "id")Long id){
        dictService.delete(id);
        return R.ok();
    }

    @GetMapping
    public R list(@ModelAttribute DictQo qo){
        return R.ok(dictService.list(qo));
    }


}
