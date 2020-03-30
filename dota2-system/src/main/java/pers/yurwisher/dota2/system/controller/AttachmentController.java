package pers.yurwisher.dota2.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pers.yurwisher.dota2.common.base.BaseController;
import pers.yurwisher.dota2.system.pojo.qo.AttachmentQo;
import pers.yurwisher.dota2.system.service.IAttachmentService;
import pers.yurwisher.wisp.wrapper.R;

/**
 * @author yq
 * @date 2019-10-30 16:02:49
 * @description 附件
 * @since V1.0.0
 */
@RestController
@RequestMapping("/attachment")
public class AttachmentController extends BaseController {
    private IAttachmentService attachmentService;

    public AttachmentController(IAttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @GetMapping
    public R list(@ModelAttribute AttachmentQo qo){
        return R.ok(attachmentService.list(qo));
    }

    /**
     * 上传文件
     */
    @PostMapping("upload")
    public R upload(@RequestParam MultipartFile file,@RequestParam(required = false) String remark){
        return R.ok(attachmentService.uploadWithRemark(file,remark));
    }
}
