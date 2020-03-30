package pers.yurwisher.dota2.document.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.yurwisher.dota2.common.base.impl.BaseServiceImpl;
import pers.yurwisher.dota2.common.wrapper.JWTUser;
import pers.yurwisher.dota2.document.entity.InterfaceDefinition;
import pers.yurwisher.dota2.document.mapper.InterfaceDefinitionMapper;
import pers.yurwisher.dota2.document.pojo.fo.InterfaceDefinitionFo;
import pers.yurwisher.dota2.document.pojo.qo.InterfaceDefinitionQo;
import pers.yurwisher.dota2.document.pojo.to.InterfaceDefinitionTo;
import pers.yurwisher.dota2.document.pojo.vo.InterfaceDefinitionNode;
import pers.yurwisher.dota2.document.pojo.vo.InterfaceDefinitionVo;
import pers.yurwisher.dota2.document.pojo.vo.InterfaceParamNode;
import pers.yurwisher.dota2.document.service.IInterfaceDefinitionService;
import pers.yurwisher.dota2.document.service.IInterfaceParamService;
import pers.yurwisher.dota2.document.service.IRequestHeadService;
import pers.yurwisher.wisp.utils.Asserts;
import pers.yurwisher.wisp.utils.CollectionUtils;
import pers.yurwisher.wisp.wrapper.PageR;
import pers.yurwisher.wisp.wrapper.Tree;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yq
 * @date 2019-11-26 14:20:01
 * @description 接口定义
 * @since V1.0.0
 */
@Service
public class InterfaceDefinitionServiceImpl extends BaseServiceImpl<InterfaceDefinitionMapper, InterfaceDefinition> implements IInterfaceDefinitionService {

    private IInterfaceParamService interfaceParamService;
    private IRequestHeadService requestHeadService;

    public InterfaceDefinitionServiceImpl(IInterfaceParamService interfaceParamService, IRequestHeadService requestHeadService) {
        this.interfaceParamService = interfaceParamService;
        this.requestHeadService = requestHeadService;
    }

    /**
     * 新增
     * @param fo 参数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(InterfaceDefinitionFo fo){
        InterfaceDefinition interfaceDefinition = new InterfaceDefinition();
        BeanUtils.copyProperties(fo,interfaceDefinition);
        baseMapper.insert(interfaceDefinition);

        //创建请求头
        requestHeadService.create(interfaceDefinition.getId(),fo.getRequestHeaders());
        //创建请求参数
        interfaceParamService.createRequestAndResponseParam(interfaceDefinition.getId(),fo.getRequestParams(),fo.getResponseParams());
    }

    /**
     * 更新
     * @param id 主键
     * @param fo 参数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Long id,InterfaceDefinitionFo fo){
        InterfaceDefinition interfaceDefinition = baseMapper.selectById(id);
        Asserts.notNull(interfaceDefinition);
        BeanUtils.copyProperties(fo,interfaceDefinition);
        baseMapper.updateById(interfaceDefinition);

        //创建请求头
        requestHeadService.create(interfaceDefinition.getId(),fo.getRequestHeaders());
        //创建请求参数
        interfaceParamService.createRequestAndResponseParam(interfaceDefinition.getId(),fo.getRequestParams(),fo.getResponseParams());
    }

    /**
    * 详情
    * @param id 主键
    * @return InterfaceDefinitionVo
    */
    @Override
    public InterfaceDefinitionVo get(Long id){
        InterfaceDefinitionVo vo = baseMapper.get(id);
        vo.setRequestHeaders(requestHeadService.getByInterfaceId(id));
        List<InterfaceParamNode> params = interfaceParamService.getInterfaceParamByInterfaceId(id);
        //拆分接口参数
        this.spiltInterfaceParam(vo,params);
        return vo;
    }

    @Override
    @SuppressWarnings("unchecked")
    public PageR<InterfaceDefinitionTo> list(InterfaceDefinitionQo qo) {
        return super.toPageR(baseMapper.list(super.toPage(qo),qo));
    }

    @Override
    public Map<String,List<InterfaceDefinitionNode>> interfaceMap(){
        List<InterfaceDefinitionNode> nodes = baseMapper.findAllNode();
        if(CollectionUtils.isNotEmpty(nodes)){
            //按模块分组
            return nodes.stream().collect(Collectors.groupingBy(InterfaceDefinitionNode::getModule));
        }
        return null;
    }

    private void spiltInterfaceParam(InterfaceDefinitionVo vo, List<InterfaceParamNode> params){
        if(CollectionUtils.isNotEmpty(params)){
            //按参数类型分组
            Map<Boolean,List<InterfaceParamNode>> map =params.stream().collect(Collectors.groupingBy(InterfaceParamNode::getRequested));
            //请求参数
            List<InterfaceParamNode> requestParams = map.get(true);
            vo.setRequestParams(new Tree<Long,InterfaceParamNode>(-1L).build(requestParams));
            //响应参数
            List<InterfaceParamNode> responseParams = map.get(false);
            vo.setResponseParams(new Tree<Long,InterfaceParamNode>(-1L).build(responseParams));
        }
    }

}
