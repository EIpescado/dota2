package pers.yurwisher.dota2.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import pers.yurwisher.dota2.common.base.CommonMapper;
import pers.yurwisher.dota2.system.entity.StatusLog;
import pers.yurwisher.dota2.system.pojo.qo.StatusLogQo;
import pers.yurwisher.dota2.system.pojo.to.StatusLogTo;

/**
 * @author yq
 * @date 2019-11-11 22:29:20
 * @description 状态日志 Mapper
 * @since V1.0.0
 */
public interface StatusLogMapper extends CommonMapper<StatusLog> {

    /**
     * 分页查询
     * @param page 分页参数
     * @param qo 查询参数
     * @return 分页结果
     */
    IPage<StatusLogTo> list(Page page, @Param("qo") StatusLogQo qo);
}
