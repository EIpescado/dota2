package pers.yurwisher.dota2.document.service;

import pers.yurwisher.dota2.common.base.BaseService;
import pers.yurwisher.dota2.document.entity.InterfaceDefinition;
import pers.yurwisher.dota2.document.pojo.fo.InterfaceDefinitionFo;
import pers.yurwisher.dota2.document.pojo.qo.InterfaceDefinitionQo;
import pers.yurwisher.dota2.document.pojo.to.InterfaceDefinitionTo;
import pers.yurwisher.dota2.document.pojo.vo.InterfaceDefinitionNode;
import pers.yurwisher.dota2.document.pojo.vo.InterfaceDefinitionVo;
import pers.yurwisher.wisp.wrapper.PageR;

import java.util.List;
import java.util.Map;


/**
 * @author yq
 * @date 2019-11-26 14:20:01
 * @description 接口定义
 * @since V1.0.0
 */
public interface IInterfaceDefinitionService extends BaseService<InterfaceDefinition> {

    /**
     * 新增
     * @param fo 参数
     */
    void create(InterfaceDefinitionFo fo);

    /**
     * 更新
     * @param id 主键
     * @param fo 参数
     */
    void update(Long id, InterfaceDefinitionFo fo);

    /**
     * 列表
     * @param qo 查询参数
     * @return 分页对象
     */
    PageR<InterfaceDefinitionTo> list(InterfaceDefinitionQo qo);

    /**
    * 详情
    * @param id 主键
    * @return InterfaceDefinitionVo
    */
    InterfaceDefinitionVo get(Long id);

    /**
     * 所有接口节点,按模块分组
     * @return Map
     */
    Map<String,List<InterfaceDefinitionNode>> interfaceMap();

}
