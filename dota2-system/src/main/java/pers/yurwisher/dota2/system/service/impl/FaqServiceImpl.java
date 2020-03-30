package pers.yurwisher.dota2.system.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.yurwisher.dota2.common.base.impl.BaseServiceImpl;
import pers.yurwisher.dota2.system.entity.Faq;
import pers.yurwisher.dota2.system.mapper.FaqMapper;
import pers.yurwisher.dota2.system.pojo.fo.FaqFo;
import pers.yurwisher.dota2.system.pojo.qo.FaqQo;
import pers.yurwisher.dota2.system.pojo.to.FaqTo;
import pers.yurwisher.dota2.system.pojo.vo.FaqVo;
import pers.yurwisher.dota2.system.service.IFaqService;
import pers.yurwisher.wisp.utils.Asserts;
import pers.yurwisher.wisp.wrapper.PageR;

/**
 * @author yq
 * @date 2019-10-15 11:33:43
 * @description 字典明细
 * @since V1.0.0
 */
@Service
public class FaqServiceImpl extends BaseServiceImpl<FaqMapper,Faq> implements IFaqService{

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(FaqFo fo){
        Faq faq = new Faq();
        BeanUtils.copyProperties(fo,faq);
        baseMapper.insert(faq);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Long id,FaqFo fo){
        Faq faq = baseMapper.selectById(id);
        Asserts.notNull(faq);
        BeanUtils.copyProperties(fo,faq);
        baseMapper.updateById(faq);
    }

    @Override
    @SuppressWarnings("unchecked")
    public PageR<FaqTo> list(FaqQo qo){
        return super.toPageR(baseMapper.list(super.toPage(qo),qo));
    }

    @Override
    public FaqVo get(Long id){
        return baseMapper.get(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id){
        baseMapper.deleteById(id);
    }
}
