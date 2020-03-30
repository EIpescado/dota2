package pers.yurwisher.dota2.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.yurwisher.dota2.common.base.BaseController;
import pers.yurwisher.dota2.system.pojo.fo.FaqFo;
import pers.yurwisher.dota2.system.pojo.qo.FaqQo;
import pers.yurwisher.dota2.system.service.IFaqService;
import pers.yurwisher.wisp.wrapper.R;

/**
 * @author yq
 * @date 2019-10-15 11:33:43
 * @description FAQ
 * @since V1.0.0
 */
@RestController
@RequestMapping("/faq")
public class FaqController extends BaseController {
    private IFaqService faqService;

    public FaqController(IFaqService faqService) {
        this.faqService = faqService;
    }

    @PostMapping
    public R create(@RequestBody FaqFo fo){
        faqService.create(fo);
        return R.ok();
    }

    @PostMapping("{id}")
    public R update(@PathVariable(name = "id")Long id, @RequestBody FaqFo fo){
        faqService.update(id,fo);
        return R.ok();
    }

    @GetMapping("{id}")
    public R get(@PathVariable(name = "id")Long id){
        return R.ok(faqService.get(id));
    }

    @PostMapping("/delete/{id}")
    public R delete(@PathVariable(name = "id")Long id){
        faqService.delete(id);
        return R.ok();
    }

    @GetMapping
    public R list(@ModelAttribute FaqQo qo){
        return R.ok(faqService.list(qo));
    }


}
