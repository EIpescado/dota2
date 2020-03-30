package pers.yurwisher.dota2.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import pers.yurwisher.dota2.common.base.CommonMapper;
import pers.yurwisher.dota2.system.entity.Faq;
import pers.yurwisher.dota2.system.pojo.qo.FaqQo;
import pers.yurwisher.dota2.system.pojo.to.FaqTo;
import pers.yurwisher.dota2.system.pojo.vo.FaqVo;

/**
 * @author yq
 * @date 2019-10-15 11:33:43
 * @description 字典明细 Mapper
 * @since V1.0.0
 */
public interface FaqMapper extends CommonMapper<Faq> {

    /**
     * 列表
     * @param page mybatis-plus分页参数
     * @param qo 查询参数
     * @return 列表
     */
    IPage<FaqTo> list(Page page, @Param("qo") FaqQo qo);

    /**
    * 详情
    * @param id ID
    * @return 详情
    */
    FaqVo get(@Param("id") Long id);


}
