package pers.yurwisher.dota2.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import pers.yurwisher.dota2.common.base.CommonMapper;
import pers.yurwisher.dota2.system.entity.Attachment;
import pers.yurwisher.dota2.system.pojo.qo.AttachmentQo;
import pers.yurwisher.dota2.system.pojo.to.AttachmentTo;

/**
 * @author yq
 * @date 2019-10-30 16:02:49
 * @description 附件 Mapper
 * @since V1.0.0
 */
public interface AttachmentMapper extends CommonMapper<Attachment> {

    /**
     * 列表
     * @param page mybatis-plus分页参数
     * @param qo 查询参数
     * @return 列表
     */
    IPage<AttachmentTo> list(Page page, @Param("qo") AttachmentQo qo);

}
