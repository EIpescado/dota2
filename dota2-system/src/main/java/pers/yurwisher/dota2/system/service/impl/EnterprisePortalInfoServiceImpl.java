package pers.yurwisher.dota2.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.yurwisher.dota2.common.base.impl.BaseServiceImpl;
import pers.yurwisher.dota2.common.constant.cache.SystemCacheConstant;
import pers.yurwisher.dota2.system.entity.EnterprisePortalInfo;
import pers.yurwisher.dota2.system.mapper.EnterprisePortalInfoMapper;
import pers.yurwisher.dota2.system.pojo.fo.EnterprisePortalInfoFo;
import pers.yurwisher.dota2.system.pojo.qo.EnterprisePortalInfoQo;
import pers.yurwisher.dota2.system.pojo.to.EnterprisePortalInfoTo;
import pers.yurwisher.dota2.system.service.IEnterprisePortalInfoService;
import pers.yurwisher.wisp.utils.Asserts;
import pers.yurwisher.wisp.wrapper.PageR;


/**
 * @author yq
 * @date 2019-10-31 09:19:05
 * @description 企业门户信息配置
 * @since V1.0.0
 */
@Service
public class EnterprisePortalInfoServiceImpl extends BaseServiceImpl<EnterprisePortalInfoMapper,EnterprisePortalInfo> implements IEnterprisePortalInfoService{

    @Override
    @SuppressWarnings("unchecked")
    public PageR<EnterprisePortalInfoTo> list(EnterprisePortalInfoQo qo) {
        return super.toPageR(baseMapper.list(super.toPage(qo),qo));
    }

    /**
     * 获取当前激活的配置
     */
    private EnterprisePortalInfo getCurrentActivated(){
        LambdaQueryWrapper<EnterprisePortalInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(EnterprisePortalInfo::getActivated,true);
        wrapper.eq(EnterprisePortalInfo::getEnabled,true);
        return baseMapper.selectOne(wrapper);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = SystemCacheConstant.ENTERPRISE_PORTAL_INFO,allEntries = true)
    public void update(Long id, EnterprisePortalInfoFo fo) {
        EnterprisePortalInfo info = baseMapper.selectById(id);
        Asserts.notNull(info);
        info.setContent(JSON.toJSONString(fo.getWebInfo()));
        info.setRemark(fo.getRemark());
        baseMapper.updateById(info);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(EnterprisePortalInfoFo fo) {
        EnterprisePortalInfo info = new EnterprisePortalInfo();
        info.setContent(JSON.toJSONString(fo.getWebInfo()));
        info.setActivated(false);
        info.setRemark(fo.getRemark());
        baseMapper.insert(info);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = SystemCacheConstant.ENTERPRISE_PORTAL_INFO,allEntries = true)
    public void activate(Long id) {
        EnterprisePortalInfo info = baseMapper.selectById(id);
        Asserts.notNull(info);
        info.setActivated(true);
        //移除之前的激活
        baseMapper.updateActivateWhichIdNotEqual(false,id);
        baseMapper.updateById(info);
    }

}
