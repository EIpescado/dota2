package pers.yurwisher.dota2.document.service;


import pers.yurwisher.dota2.common.base.BaseService;
import pers.yurwisher.dota2.document.entity.RequestHead;
import pers.yurwisher.dota2.document.pojo.fo.RequestHeadFo;
import pers.yurwisher.dota2.document.pojo.vo.RequestHeadVo;

import java.util.List;


/**
 * @author yq
 * @date 2019-11-27 11:16:10
 * @description 请求头
 * @since V1.0.0
 */
public interface IRequestHeadService extends BaseService<RequestHead> {

    /**
     * 新增接口请求头
     * @param interfaceId 接口ID
     * @param requestHeaders 请求头
     */
    void create(Long interfaceId, List<RequestHeadFo> requestHeaders);

    /**
     *  获取接口请求头
     * @param interfaceId 接口ID
     * @return 集合
     */
    List<RequestHeadVo> getByInterfaceId(Long interfaceId);
}
