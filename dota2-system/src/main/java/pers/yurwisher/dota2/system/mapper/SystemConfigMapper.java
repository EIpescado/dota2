package pers.yurwisher.dota2.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import pers.yurwisher.dota2.system.entity.SystemConfig;
import pers.yurwisher.dota2.system.pojo.qo.SystemConfigQo;
import pers.yurwisher.dota2.system.pojo.to.SystemConfigTo;
import pers.yurwisher.dota2.system.pojo.vo.SystemConfigVo;


/**
 * <p>
 * 系统配置 Mapper 接口
 * </p>
 *
 * @author yq
 * @since 2018-12-04
 */
public interface SystemConfigMapper extends BaseMapper<SystemConfig> {

    /**
     * 分页查询
     * @param page 分页参数
     * @param qo 查询参数
     * @return 分页结果
     */
    IPage<SystemConfigTo> list(Page page, @Param("qo") SystemConfigQo qo);

    /**
     * 详情
     * @param id 主键
     * @return vo
     */
    SystemConfigVo get(@Param("id") Long id);
}
