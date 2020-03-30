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
import pers.yurwisher.dota2.system.pojo.fo.DictMemberFo;
import pers.yurwisher.dota2.system.pojo.qo.DictMemberQo;
import pers.yurwisher.dota2.system.service.IDictMemberService;
import pers.yurwisher.wisp.wrapper.R;

/**
 * @author yq
 * @date 2019-10-14 13:56:10
 * @description 字典明细
 * @since V1.0.0
 */
@RestController
@RequestMapping("/dictMember")
public class DictMemberController extends BaseController {
    private IDictMemberService dictMemberService;

    public DictMemberController(IDictMemberService dictMemberService) {
        this.dictMemberService = dictMemberService;
    }

    @PostMapping
    public R create(@RequestBody DictMemberFo fo){
        dictMemberService.create(fo);
        return R.ok();
    }

    @PostMapping("{id}")
    public R update(@PathVariable(name = "id")Long id, @RequestBody DictMemberFo fo){
        dictMemberService.update(id,fo);
        return R.ok();
    }

    @GetMapping("{id}")
    public R get(@PathVariable(name = "id")Long id){
        return R.ok(dictMemberService.get(id));
    }

    @PostMapping("/delete/{id}")
    public R delete(@PathVariable(name = "id")Long id){
        dictMemberService.delete(id);
        return R.ok();
    }

    @GetMapping
    public R list(@ModelAttribute DictMemberQo qo){
        return R.ok(dictMemberService.list(qo));
    }

    @GetMapping("select")
    public R select(@RequestParam String dictName){
        return R.ok(dictMemberService.select(dictName));
    }

}
