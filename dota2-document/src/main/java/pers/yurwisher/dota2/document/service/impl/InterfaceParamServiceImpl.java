package pers.yurwisher.dota2.document.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.yurwisher.dota2.common.base.impl.BaseServiceImpl;
import pers.yurwisher.dota2.document.entity.InterfaceParam;
import pers.yurwisher.dota2.document.mapper.InterfaceParamMapper;
import pers.yurwisher.dota2.document.pojo.fo.InterfaceParamFo;
import pers.yurwisher.dota2.document.pojo.vo.InterfaceParamNode;
import pers.yurwisher.dota2.document.service.IInterfaceParamService;
import pers.yurwisher.wisp.utils.CollectionUtils;

import java.util.List;

/**
 * @author yq
 * @date 2019-11-26 14:42:33
 * @description 接口参数
 * @since V1.0.0
 */
@Service
public class InterfaceParamServiceImpl extends BaseServiceImpl<InterfaceParamMapper, InterfaceParam> implements IInterfaceParamService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createRequestAndResponseParam(Long interfaceId, List<InterfaceParamFo> requestParams, List<InterfaceParamFo> responseParams) {
        //删除旧的参数
        baseMapper.deleteByInterfaceId(interfaceId);
        //请求参数
        if(CollectionUtils.isNotEmpty(requestParams)){
            this.loopSave(interfaceId,null,requestParams,true);
        }
        //响应参数
        if(CollectionUtils.isNotEmpty(responseParams)){
            this.loopSave(interfaceId,null,responseParams,false);
        }
    }

    @Override
    public List<InterfaceParamNode> getInterfaceParamByInterfaceId(Long interfaceId) {
        return baseMapper.getInterfaceParamByInterfaceId(interfaceId);
    }

    private void loopSave(Long interfaceId,Long parentId,List<InterfaceParamFo> requestParams,boolean requested){
        if(CollectionUtils.isNotEmpty(requestParams)){
            requestParams.forEach(p ->{
                InterfaceParam ip = new InterfaceParam();
                BeanUtils.copyProperties(p,ip);
                ip.setRequested(requested);
                ip.setParentId(parentId);
                ip.setInterfaceId(interfaceId);
                baseMapper.insert(ip);
                if(CollectionUtils.isNotEmpty(p.getChildren())){
                    this.loopSave(interfaceId,ip.getId(),p.getChildren(),requested);
                }
            });
        }
    }
}
