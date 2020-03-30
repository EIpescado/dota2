package pers.yurwisher.dota2.system.service;

import pers.yurwisher.dota2.common.base.BaseService;
import pers.yurwisher.dota2.system.entity.Dict;
import pers.yurwisher.dota2.system.pojo.fo.DictFo;
import pers.yurwisher.dota2.system.pojo.qo.DictQo;
import pers.yurwisher.dota2.system.pojo.to.DictTo;
import pers.yurwisher.dota2.system.pojo.vo.DictVo;
import pers.yurwisher.wisp.wrapper.PageR;


/**
 * @author yq
 * @date 2019-10-14 13:55:36
 * @description 字典
 * @since V1.0.0
 */
public interface IDictService extends BaseService<Dict> {

    /**
     * 新增
     * @param fo 参数
     */
    void create(DictFo fo);

    /**
     * 更新
     * @param id 主键
     * @param fo 参数
     */
    void update(Long id, DictFo fo);

    /**
     * 列表
     * @param qo 查询参数
     * @return 分页对象
     */
    PageR<DictTo> list(DictQo qo);


    /**
    * 详情
    * @param id 主键
    * @return DictVo
    */
    DictVo get(Long id);

     /**
     * 删除
     * @param id 主键
     */
    void delete(Long id);

}
