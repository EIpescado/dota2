package pers.yurwisher.dota2.document.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.yurwisher.dota2.common.base.impl.BaseServiceImpl;
import pers.yurwisher.dota2.document.entity.RequestHead;
import pers.yurwisher.dota2.document.mapper.RequestHeadMapper;
import pers.yurwisher.dota2.document.pojo.fo.RequestHeadFo;
import pers.yurwisher.dota2.document.pojo.vo.RequestHeadVo;
import pers.yurwisher.dota2.document.service.IRequestHeadService;
import pers.yurwisher.wisp.utils.CollectionUtils;

import java.util.List;

/**
 * @author yq
 * @date 2019-11-27 11:16:10
 * @description 请求头
 * @since V1.0.0
 */
@Service
public class RequestHeadServiceImpl extends BaseServiceImpl<RequestHeadMapper, RequestHead> implements IRequestHeadService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(Long interfaceId, List<RequestHeadFo> requestHeaders) {
        //删除旧
        baseMapper.deleteByInterfaceId(interfaceId);
        if(CollectionUtils.isNotEmpty(requestHeaders)){
            requestHeaders.forEach(h ->{
                RequestHead head = new RequestHead();
                BeanUtils.copyProperties(h,head);
                head.setInterfaceId(interfaceId);
                baseMapper.insert(head);
            });
        }
    }

    @Override
    public List<RequestHeadVo> getByInterfaceId(Long interfaceId) {
        return baseMapper.getByInterfaceId(interfaceId);
    }
}
