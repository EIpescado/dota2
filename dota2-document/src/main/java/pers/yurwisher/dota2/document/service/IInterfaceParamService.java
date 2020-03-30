package pers.yurwisher.dota2.document.service;


import pers.yurwisher.dota2.common.base.BaseService;
import pers.yurwisher.dota2.document.entity.InterfaceParam;
import pers.yurwisher.dota2.document.pojo.fo.InterfaceParamFo;
import pers.yurwisher.dota2.document.pojo.vo.InterfaceParamNode;

import java.util.List;

/**
 * @author yq
 * @date 2019-11-26 14:42:33
 * @description 接口参数
 * @since V1.0.0
 */
public interface IInterfaceParamService extends BaseService<InterfaceParam> {

    /**
     * 新增参数
     * @param interfaceId 接口ID
     * @param requestParams 请求参数
     * @param responseParams 响应参数
     */
    void createRequestAndResponseParam(Long interfaceId, List<InterfaceParamFo> requestParams, List<InterfaceParamFo> responseParams);

    /**
     * 参数 根据接口
     * @param interfaceId 接口ID
     * @return 参数集合
     */
    List<InterfaceParamNode> getInterfaceParamByInterfaceId(Long interfaceId);

}
