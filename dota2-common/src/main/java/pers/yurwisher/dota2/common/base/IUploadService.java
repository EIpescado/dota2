package pers.yurwisher.dota2.common.base;

import java.io.InputStream;

/**
 * @author yq
 * @date 2019年12月17日 14:25:03
 * @description upload service
 * @since V1.0.0
 */
public interface IUploadService {

    /**
     * 上传文件 附件上传后的文件地址
     * @param stream 输入流
     * @return 文件访问地址
     */
    String upload(InputStream stream);
}
