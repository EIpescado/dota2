package pers.yurwisher.dota2.system.service;

import org.springframework.web.multipart.MultipartFile;
import pers.yurwisher.dota2.common.base.BaseService;
import pers.yurwisher.dota2.system.entity.Attachment;
import pers.yurwisher.dota2.system.pojo.qo.AttachmentQo;
import pers.yurwisher.dota2.system.pojo.to.AttachmentTo;
import pers.yurwisher.wisp.wrapper.PageR;


/**
 * @author yq
 * @date 2019-10-30 16:02:49
 * @description 附件
 * @since V1.0.0
 */
public interface IAttachmentService extends BaseService<Attachment> {


    /**
     * 列表
     * @param qo 查询参数
     * @return 分页对象
     */
    PageR<AttachmentTo> list(AttachmentQo qo);

    /**
     * 上传文件
     * @param file 文件
     * @param maxSizeKey 文件
     * @return 附件实体
     */
    Attachment upload(MultipartFile file, String maxSizeKey);

    /**
     * 上传文件
     * @param file 文件
     * @return 附件实体
     */
    Attachment upload(MultipartFile file);

    /**
     * 上传文件
     * @param file 文件
     * @param maxSizeKey 文件
     * @param fileName 原始文件名称
     * @param remark 文件备注
     * @return 附件实体
     */
    Attachment upload(MultipartFile file, String fileName, String maxSizeKey, String remark);

    /**
     * 上传文件
     * @param file 文件
     * @param remark 备注
     * @return 附件实体
     */
    Attachment uploadWithRemark(MultipartFile file, String remark);
}
