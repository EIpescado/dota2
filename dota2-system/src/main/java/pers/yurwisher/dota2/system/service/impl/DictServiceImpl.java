package pers.yurwisher.dota2.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.yurwisher.dota2.common.base.impl.BaseServiceImpl;
import pers.yurwisher.dota2.common.enums.tip.SystemCustomTipEnum;
import pers.yurwisher.dota2.common.exception.SystemException;
import pers.yurwisher.dota2.system.entity.Dict;
import pers.yurwisher.dota2.system.mapper.DictMapper;
import pers.yurwisher.dota2.system.pojo.fo.DictFo;
import pers.yurwisher.dota2.system.pojo.qo.DictQo;
import pers.yurwisher.dota2.system.pojo.to.DictTo;
import pers.yurwisher.dota2.system.pojo.vo.DictVo;
import pers.yurwisher.dota2.system.service.IDictMemberService;
import pers.yurwisher.dota2.system.service.IDictService;
import pers.yurwisher.wisp.utils.Asserts;
import pers.yurwisher.wisp.wrapper.PageR;

/**
 * @author yq
 * @date 2019-10-14 13:55:36
 * @description 字典
 * @since V1.0.0
 */
@Service
public class DictServiceImpl extends BaseServiceImpl<DictMapper,Dict> implements IDictService{

    private IDictMemberService dictMemberService;

    public DictServiceImpl(IDictMemberService dictMemberService) {
        this.dictMemberService = dictMemberService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(DictFo fo){
        //校验名称 需唯一
        checkName(fo.getName());
        Dict dict = new Dict();
        BeanUtils.copyProperties(fo,dict);
        baseMapper.insert(dict);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Long id,DictFo fo){
        Dict dict = baseMapper.selectById(id);
        Asserts.notNull(dict);
        if(!dict.getName().equals(fo.getName())){
            throw new SystemException(SystemCustomTipEnum.DICT_NAME_CAN_NOT_CHANGE);
        }
        BeanUtils.copyProperties(fo,dict);
        baseMapper.updateById(dict);
    }

    private void checkName(String name){
       Integer count =  baseMapper.selectCount(Wrappers.<Dict>lambdaQuery().eq(Dict::getName,name));
       if(count != null && count != 0){
           throw new SystemException(SystemCustomTipEnum.DICT_NAME_EXIST);
       }
    }

    @Override
    @SuppressWarnings("unchecked")
    public PageR<DictTo> list(DictQo qo){
        return super.toPageR(baseMapper.list(super.toPage(qo),qo));
    }

    @Override
    public DictVo get(Long id){
        return baseMapper.get(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id){
        Dict dict = baseMapper.selectById(id);
        if(dict != null){
            baseMapper.deleteById(id);
            dictMemberService.deleteByDictName(dict.getName());
        }
    }

}
