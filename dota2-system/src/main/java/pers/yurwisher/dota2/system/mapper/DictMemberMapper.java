package pers.yurwisher.dota2.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import pers.yurwisher.dota2.common.base.CommonMapper;
import pers.yurwisher.dota2.system.entity.DictMember;
import pers.yurwisher.dota2.system.pojo.qo.DictMemberQo;
import pers.yurwisher.dota2.system.pojo.so.DictSo;
import pers.yurwisher.dota2.system.pojo.to.DictMemberTo;
import pers.yurwisher.dota2.system.pojo.vo.DictMemberVo;
import pers.yurwisher.wisp.wrapper.So;

import java.util.List;

/**
 * @author yq
 * @date 2019-10-14 13:56:10
 * @description 字典明细 Mapper
 * @since V1.0.0
 */
public interface DictMemberMapper extends CommonMapper<DictMember> {

    /**
     * 列表
     * @param page mybatis-plus分页参数
     * @param qo 查询参数
     * @return 列表
     */
    IPage<DictMemberTo> list(Page page, @Param("qo") DictMemberQo qo);

    /**
    * 详情
    * @param id ID
    * @return 详情
    */
    DictMemberVo get(@Param("id") Long id);

    /**
     * 根据字典ID删除字典详情
     * @param dictName 字典名称
     * @return int
     */
    Integer deleteByDictName(@Param("dictName") String dictName);

    /**
     * 字典下拉框
     * @param dictName 字典name
     * @return  so
     */
    List<So<String>> select(@Param("dictName") String dictName);
}
