package pers.yurwisher.dota2.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.yurwisher.dota2.common.base.BaseController;
import pers.yurwisher.dota2.system.pojo.fo.NoticeFo;
import pers.yurwisher.dota2.system.pojo.qo.MessageQo;
import pers.yurwisher.dota2.system.pojo.vo.UnReadMessage;
import pers.yurwisher.dota2.system.service.IMessageService;
import pers.yurwisher.wisp.wrapper.R;

/**
 * @author yq
 * @date 2019-08-15 17:07:13
 * @description 消息
 * @since V1.0.0
 */
@RestController
@RequestMapping("/message")
public class MessageController extends BaseController {
    private IMessageService messageService;

    public MessageController(IMessageService messageService) {
        this.messageService = messageService;
    }

    /**
     * 站内信列表,用户与用户之间
     */
    @GetMapping("web")
    public R web(@ModelAttribute MessageQo qo){
        return R.ok(messageService.webList(qo));
    }

    /**
     * 系统消息列表,即系统推送给单个用户的提示信息
     */
    @GetMapping("system")
    public R system(@ModelAttribute MessageQo qo){
        return R.ok(messageService.systemList(qo));
    }

    /**
     * 系统公告
     */
    @GetMapping("notice")
    public R notice(@ModelAttribute MessageQo qo){
        return R.ok(messageService.noticeList(qo));
    }

    /**
     * 系统公告
     */
    @GetMapping("notice/{id}")
    public R noticeDetail(@PathVariable Long id){
        return R.ok(messageService.getNoticeDetail(id));
    }

    /**
     * 新增系统公告
     */
    @PostMapping("notice")
    public R createNotice(@RequestBody NoticeFo fo){
        messageService.createNotice(fo);
        return R.ok();
    }

    /**
     * 修改系统公告
     */
    @PostMapping("/notice/{id}")
    public R updateNotice(@RequestBody NoticeFo fo, @PathVariable Long id){
        messageService.updateNotice(id,fo);
        return R.ok();
    }

    /**
     * 消息中心 未读消息汇总
     */
    @GetMapping("unReadSummarize")
    public R<UnReadMessage> unReadSummarize(){
        return R.ok(messageService.unReadSummarize());
    }
}
