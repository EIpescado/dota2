package pers.yurwisher.dota2.document.mapper;

import pers.yurwisher.dota2.common.base.CommonMapper;
import pers.yurwisher.dota2.document.entity.RequestHead;
import org.apache.ibatis.annotations.Param;
import pers.yurwisher.dota2.document.pojo.vo.RequestHeadVo;

import java.util.List;


/**
 * @author yq
 * @date 2019-11-27 11:16:10
 * @description 请求头 Mapper
 * @since V1.0.0
 */
public interface RequestHeadMapper extends CommonMapper<RequestHead> {

    /**
     * 删除请求头
     * @param interfaceId 接口ID
     * @return 数量
     */
    Integer deleteByInterfaceId(@Param("interfaceId") Long interfaceId);

    /**
     * 获取接口请求头
     * @param interfaceId 接口
     * @return 集合
     */
    List<RequestHeadVo> getByInterfaceId(@Param("interfaceId") Long interfaceId);
}
