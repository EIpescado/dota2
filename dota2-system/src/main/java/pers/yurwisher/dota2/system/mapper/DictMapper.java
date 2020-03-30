package pers.yurwisher.dota2.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import pers.yurwisher.dota2.common.base.CommonMapper;
import pers.yurwisher.dota2.system.entity.Dict;
import pers.yurwisher.dota2.system.pojo.qo.DictQo;
import pers.yurwisher.dota2.system.pojo.to.DictTo;
import pers.yurwisher.dota2.system.pojo.vo.DictVo;

/**
 * @author yq
 * @date 2019-10-14 13:55:36
 * @description 字典 Mapper
 * @since V1.0.0
 */
public interface DictMapper extends CommonMapper<Dict> {

    /**
     * 列表
     * @param page mybatis-plus分页参数
     * @param qo 查询参数
     * @return 列表
     */
    IPage<DictTo> list(Page page, @Param("qo") DictQo qo);

    /**
    * 详情
    * @param id ID
    * @return 详情
    */
    DictVo get(@Param("id") Long id);

}
