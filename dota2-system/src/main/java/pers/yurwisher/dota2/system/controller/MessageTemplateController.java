package pers.yurwisher.dota2.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.yurwisher.dota2.common.base.BaseController;
import pers.yurwisher.dota2.system.pojo.fo.MessageTemplateFo;
import pers.yurwisher.dota2.system.pojo.qo.MessageTemplateQo;
import pers.yurwisher.dota2.system.service.IMessageTemplateService;
import pers.yurwisher.wisp.wrapper.R;

/**
 * @author yq
 * @date 2019-08-23 10:23:01
 * @description 消息模版
 * @since V1.0.0
 */
@RestController
@RequestMapping("/messageTemplate")
public class MessageTemplateController extends BaseController {
    private IMessageTemplateService messageTemplateService;

    public MessageTemplateController(IMessageTemplateService messageTemplateService) {
        this.messageTemplateService = messageTemplateService;
    }

    @PostMapping
    public R create(@RequestBody MessageTemplateFo fo) {
        messageTemplateService.create(fo);
        return R.ok();
    }

    @PostMapping("{id}")
    public R update(@PathVariable(name = "id") Long id, @RequestBody MessageTemplateFo fo) {
        messageTemplateService.update(id, fo);
        return R.ok();
    }

    @PostMapping("/delete/{id}")
    public R delete(@PathVariable(name = "id") Long id) {
        messageTemplateService.delete(id);
        return R.ok();
    }

    @GetMapping
    public R list(@ModelAttribute MessageTemplateQo qo) {
        return R.ok(messageTemplateService.list(qo));
    }

    @GetMapping("{id}")
    public R get(@PathVariable Long id) {
        return R.ok(messageTemplateService.get(id));
    }

}
