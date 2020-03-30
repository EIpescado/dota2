package pers.yurwisher.dota2.system.service;

import pers.yurwisher.dota2.common.base.BaseService;
import pers.yurwisher.dota2.system.entity.Faq;
import pers.yurwisher.dota2.system.pojo.fo.FaqFo;
import pers.yurwisher.dota2.system.pojo.qo.FaqQo;
import pers.yurwisher.dota2.system.pojo.to.FaqTo;
import pers.yurwisher.dota2.system.pojo.vo.FaqVo;
import pers.yurwisher.wisp.wrapper.PageR;


/**
 * @author yq
 * @date 2019-10-15 11:33:43
 * @description 字典明细
 * @since V1.0.0
 */
public interface IFaqService extends BaseService<Faq> {

    /**
     * 新增
     * @param fo 参数
     */
    void create(FaqFo fo);

    /**
     * 更新
     * @param id 主键
     * @param fo 参数
     */
    void update(Long id, FaqFo fo);

    /**
     * 列表
     * @param qo 查询参数
     * @return 分页对象
     */
    PageR<FaqTo> list(FaqQo qo);


    /**
    * 详情
    * @param id 主键
    * @return FaqVo
    */
    FaqVo get(Long id);

     /**
     * 删除
     * @param id 主键
     */
    void delete(Long id);
}
