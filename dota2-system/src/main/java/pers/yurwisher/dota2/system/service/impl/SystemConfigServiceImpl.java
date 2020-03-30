package pers.yurwisher.dota2.system.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.yurwisher.dota2.common.base.impl.BaseServiceImpl;
import pers.yurwisher.dota2.common.constant.cache.SystemCacheConstant;
import pers.yurwisher.dota2.system.entity.SystemConfig;
import pers.yurwisher.dota2.system.mapper.SystemConfigMapper;
import pers.yurwisher.dota2.system.pojo.fo.SystemConfigFo;
import pers.yurwisher.dota2.system.pojo.qo.SystemConfigQo;
import pers.yurwisher.dota2.system.pojo.vo.SystemConfigVo;
import pers.yurwisher.dota2.system.service.ISystemConfigService;
import pers.yurwisher.wisp.utils.Asserts;
import pers.yurwisher.wisp.wrapper.PageR;

import java.time.LocalDateTime;


/**
 * <p>
 * 系统配置 服务实现类
 * </p>
 *
 * @author yq
 * @since 2018-12-04
 */
@Service
public class SystemConfigServiceImpl extends BaseServiceImpl<SystemConfigMapper, SystemConfig> implements ISystemConfigService {

    @Override
    public PageR list(SystemConfigQo qo) {
        return  super.toPageR(baseMapper.list(super.toPage(qo),qo));
    }

    @Override
    @Cacheable(value = SystemCacheConstant.SYSTEM_CONFIG_CODE_VALUE,key = "#code",unless = "#result == null")
    public String getValByCode(String code) {
        SystemConfig systemConfig =  findByCode(code);
        if(systemConfig != null){
            return systemConfig.getVal();
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(SystemConfigFo fo) {
        SystemConfig config = new SystemConfig();
        BeanUtils.copyProperties(fo,config);
        baseMapper.insert(config);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = SystemCacheConstant.SYSTEM_CONFIG_CODE_VALUE,key = "#fo.code")
    public void update(Long id, SystemConfigFo fo) {
        SystemConfig config = baseMapper.selectById(id);
        Asserts.notNull(config);
        BeanUtils.copyProperties(fo,config);
        baseMapper.updateById(config);
    }

    @Override
    public SystemConfigVo get(Long id) {
        return baseMapper.get(id);
    }

    @Override
    public SystemConfig findByCode(String code){
        return baseMapper.selectOne(Wrappers.<SystemConfig>lambdaQuery().eq(SystemConfig::getCode, code).eq(SystemConfig::getEnabled, true));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = SystemCacheConstant.SYSTEM_CONFIG_CODE_VALUE, key = "#code")
    public void updateByCode(String code, String value) {
        this.update(Wrappers.<SystemConfig>lambdaUpdate()
                .set(SystemConfig::getVal, value)
                .set(SystemConfig::getLastUpdated, LocalDateTime.now())
                .eq(SystemConfig::getCode, code)
        );
    }

}
