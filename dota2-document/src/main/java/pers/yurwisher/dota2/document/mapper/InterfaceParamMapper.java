package pers.yurwisher.dota2.document.mapper;

import pers.yurwisher.dota2.common.base.CommonMapper;
import pers.yurwisher.dota2.document.entity.InterfaceParam;
import pers.yurwisher.dota2.document.pojo.vo.InterfaceParamNode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yq
 * @date 2019-11-26 14:42:33
 * @description 接口参数 Mapper
 * @since V1.0.0
 */
public interface InterfaceParamMapper extends CommonMapper<InterfaceParam> {

    /**
     * 删除参数
     * @param interfaceId 接口ID
     * @return 数量
     */
    Integer deleteByInterfaceId(@Param("interfaceId") Long interfaceId);

    /**
     * 接口参数
     * @param interfaceId 接口ID
     * @return 参数集合
     */
    List<InterfaceParamNode> getInterfaceParamByInterfaceId(@Param("interfaceId") Long interfaceId);
}
