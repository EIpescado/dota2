package pers.yurwisher.dota2.system.service;

import pers.yurwisher.dota2.common.base.BaseService;
import pers.yurwisher.dota2.system.entity.DictMember;
import pers.yurwisher.dota2.system.pojo.fo.DictMemberFo;
import pers.yurwisher.dota2.system.pojo.qo.DictMemberQo;
import pers.yurwisher.dota2.system.pojo.so.DictSo;
import pers.yurwisher.dota2.system.pojo.to.DictMemberTo;
import pers.yurwisher.dota2.system.pojo.vo.DictMemberVo;
import pers.yurwisher.wisp.wrapper.PageR;
import pers.yurwisher.wisp.wrapper.So;

import java.util.List;


/**
 * @author yq
 * @date 2019-10-14 13:56:10
 * @description 字典明细
 * @since V1.0.0
 */
public interface IDictMemberService extends BaseService<DictMember> {

    /**
     * 新增
     * @param fo 参数
     */
    void create(DictMemberFo fo);

    /**
     * 更新
     * @param id 主键
     * @param fo 参数
     */
    void update(Long id, DictMemberFo fo);

    /**
     * 列表
     * @param qo 查询参数
     * @return 分页对象
     */
    PageR<DictMemberTo> list(DictMemberQo qo);


    /**
    * 详情
    * @param id 主键
    * @return DictMemberVo
    */
    DictMemberVo get(Long id);

     /**
     * 删除
     * @param id 主键
     */
    void delete(Long id);

    /**
     * 根据字典ID删除
     * @param dictName 字典名称
     */
    void deleteByDictName(String dictName);

    /**
     * 字典详情下拉框
     * @param dictName 字典name
     * @return so
     */
    List<So<String>> select(String dictName);
}
