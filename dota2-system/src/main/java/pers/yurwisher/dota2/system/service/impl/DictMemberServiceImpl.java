package pers.yurwisher.dota2.system.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.yurwisher.dota2.common.base.impl.BaseServiceImpl;
import pers.yurwisher.dota2.common.constant.cache.SystemCacheConstant;
import pers.yurwisher.dota2.system.entity.DictMember;
import pers.yurwisher.dota2.system.mapper.DictMemberMapper;
import pers.yurwisher.dota2.system.pojo.fo.DictMemberFo;
import pers.yurwisher.dota2.system.pojo.qo.DictMemberQo;
import pers.yurwisher.dota2.system.pojo.to.DictMemberTo;
import pers.yurwisher.dota2.system.pojo.vo.DictMemberVo;
import pers.yurwisher.dota2.system.service.IDictMemberService;
import pers.yurwisher.wisp.utils.Asserts;
import pers.yurwisher.wisp.wrapper.PageR;
import pers.yurwisher.wisp.wrapper.So;

import java.util.List;

/**
 * @author yq
 * @date 2019-10-14 13:56:10
 * @description 字典明细
 * @since V1.0.0
 */
@Service
public class DictMemberServiceImpl extends BaseServiceImpl<DictMemberMapper,DictMember> implements IDictMemberService{

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = SystemCacheConstant.DICT_SELECT,key = "#fo.dictName")
    public void create(DictMemberFo fo){
        DictMember dictMember = new DictMember();
        BeanUtils.copyProperties(fo,dictMember);
        baseMapper.insert(dictMember);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = SystemCacheConstant.DICT_SELECT,key = "#fo.dictName")
    public void update(Long id,DictMemberFo fo){
        DictMember dictMember = baseMapper.selectById(id);
        Asserts.notNull(dictMember);
        BeanUtils.copyProperties(fo,dictMember);
        baseMapper.updateById(dictMember);
    }

    @Override
    @SuppressWarnings("unchecked")
    public PageR<DictMemberTo> list(DictMemberQo qo){
        return super.toPageR(baseMapper.list(super.toPage(qo),qo));
    }

    @Override
    public DictMemberVo get(Long id){
        return baseMapper.get(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = SystemCacheConstant.DICT_SELECT,allEntries = true)
    public void delete(Long id){
        baseMapper.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = SystemCacheConstant.DICT_SELECT,key = "#dictName")
    public void deleteByDictName(String dictName) {
        baseMapper.deleteByDictName(dictName);
    }

    @Override
    @Cacheable(value = SystemCacheConstant.DICT_SELECT,key = "#dictName",unless = "#result == null")
    public List<So<String>> select(String dictName) {
        return baseMapper.select(dictName);
    }
}
