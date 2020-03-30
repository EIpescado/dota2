package pers.yurwisher.dota2.document.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import pers.yurwisher.dota2.common.base.CommonMapper;
import pers.yurwisher.dota2.document.entity.InterfaceDefinition;
import pers.yurwisher.dota2.document.pojo.qo.InterfaceDefinitionQo;
import pers.yurwisher.dota2.document.pojo.to.InterfaceDefinitionTo;
import pers.yurwisher.dota2.document.pojo.vo.InterfaceDefinitionNode;
import pers.yurwisher.dota2.document.pojo.vo.InterfaceDefinitionVo;

import java.util.List;

/**
 * @author yq
 * @date 2019-11-26 14:20:01
 * @description 接口定义 Mapper
 * @since V1.0.0
 */
public interface InterfaceDefinitionMapper extends CommonMapper<InterfaceDefinition> {

    /**
     * 列表
     * @param page mybatis-plus分页参数
     * @param qo 查询参数
     * @return 列表
     */
    IPage<InterfaceDefinitionTo> list(Page page, @Param("qo") InterfaceDefinitionQo qo);
    /**
    * 详情
    * @param id ID
    * @return 详情
    */
    InterfaceDefinitionVo get(@Param("id") Long id);

    /**
     * 所有接口
     * @return 所有接口
     */
    List<InterfaceDefinitionNode> findAllNode();

}
