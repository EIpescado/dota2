package pers.yurwisher.dota2.system.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import pers.yurwisher.dota2.common.base.IUploadService;
import pers.yurwisher.dota2.common.base.impl.BaseServiceImpl;
import pers.yurwisher.dota2.common.constant.SystemConfigCodeConstant;
import pers.yurwisher.dota2.common.enums.tip.SystemCustomTipEnum;
import pers.yurwisher.dota2.common.exception.SystemException;
import pers.yurwisher.dota2.common.utils.Utils;
import pers.yurwisher.dota2.common.wrapper.JWTUser;
import pers.yurwisher.dota2.system.entity.Attachment;
import pers.yurwisher.dota2.system.mapper.AttachmentMapper;
import pers.yurwisher.dota2.system.pojo.qo.AttachmentQo;
import pers.yurwisher.dota2.system.pojo.to.AttachmentTo;
import pers.yurwisher.dota2.system.service.IAttachmentService;
import pers.yurwisher.dota2.system.service.ISystemConfigService;
import pers.yurwisher.wisp.utils.StringUtils;
import pers.yurwisher.wisp.wrapper.PageR;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author yq
 * @date 2019-10-30 16:02:49
 * @description 附件
 * @since V1.0.0
 */
@Service
public class AttachmentServiceImpl extends BaseServiceImpl<AttachmentMapper, Attachment> implements IAttachmentService {

    private ISystemConfigService systemConfigService;
    private IUploadService uploadService;

    public AttachmentServiceImpl(ISystemConfigService systemConfigService, IUploadService uploadService) {
        this.systemConfigService = systemConfigService;
        this.uploadService = uploadService;
    }

    @Override
    @SuppressWarnings("unchecked")
    public PageR<AttachmentTo> list(AttachmentQo qo) {
        return super.toPageR(baseMapper.list(super.toPage(qo), qo));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Attachment upload(MultipartFile file, String maxSizeKey) {
        return this.upload(file, file.getOriginalFilename(), maxSizeKey,null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Attachment upload(MultipartFile file) {
        return this.upload(file, file.getOriginalFilename(), SystemConfigCodeConstant.ATTACHMENT_MAX_SIZE,null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Attachment upload(MultipartFile file, String fileName, String maxSizeKey,String remark) {
        if (file == null || file.isEmpty()) {
            throw new SystemException(SystemCustomTipEnum.ATTACHMENT_INVALID);
        }
        Long maxSize = Utils.parseLong(systemConfigService.getValByCode(maxSizeKey));
        //限制附件上传大小
        if (maxSize != null && file.getSize() > maxSize) {
            throw new SystemException(SystemCustomTipEnum.ATTACHMENT_SIZE_TOO_LARGE);
        }
        try {
            String fileUrl = uploadService.upload(file.getInputStream());
            if (StringUtils.isNotEmpty(fileUrl)) {
                Attachment attachment = new Attachment();
                attachment.setUploadUserId(JWTUser.currentUserId());
                attachment.setFileName(fileName);
                attachment.setFileType(Utils.getFileType(fileName));
                //文件路径 前缀在返回信息时拼接
                attachment.setFileAddress(fileUrl);
                attachment.setUploadDate(LocalDateTime.now());
                attachment.setRemark(remark);
                baseMapper.insert(attachment);
                return attachment;
            } else {
                logger.info("上传响应为空");
                throw new SystemException(SystemCustomTipEnum.ATTACHMENT_UPLOAD_ERROR);
            }
        } catch (IOException e) {
            logger.error("上传文件失败", e);
            throw new SystemException(SystemCustomTipEnum.ATTACHMENT_UPLOAD_ERROR);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Attachment uploadWithRemark(MultipartFile file, String remark) {
        return this.upload(file, file.getOriginalFilename(), SystemConfigCodeConstant.ATTACHMENT_MAX_SIZE,remark);
    }
}
