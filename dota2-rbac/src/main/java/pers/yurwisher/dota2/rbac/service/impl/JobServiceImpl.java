package pers.yurwisher.dota2.rbac.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.yurwisher.dota2.common.base.impl.BaseServiceImpl;
import pers.yurwisher.dota2.common.constant.cache.RBACCacheConstant;
import pers.yurwisher.dota2.rbac.entity.Job;
import pers.yurwisher.dota2.rbac.mapper.JobMapper;
import pers.yurwisher.dota2.rbac.pojo.fo.JobFo;
import pers.yurwisher.dota2.rbac.pojo.qo.JobQo;
import pers.yurwisher.dota2.rbac.pojo.to.JobTo;
import pers.yurwisher.dota2.rbac.pojo.vo.JobVo;
import pers.yurwisher.dota2.rbac.service.IJobService;
import pers.yurwisher.wisp.utils.Asserts;
import pers.yurwisher.wisp.wrapper.PageR;
import pers.yurwisher.wisp.wrapper.So;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author yq
 * @date 2019-07-22 17:30:48
 * @description 职位
 * @since V1.0.0
 */
@Service
@CacheConfig(cacheNames = RBACCacheConstant.DEPARTMENT_JOB)
public class JobServiceImpl extends BaseServiceImpl<JobMapper,Job> implements IJobService{

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(key = "#fo.departmentId")
    public void create(JobFo fo){
        Job job = new Job();
        BeanUtils.copyProperties(fo,job);
        job.setEnabled(true);
        job.setDateCreated(LocalDateTime.now());
        baseMapper.insert(job);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(key = "#fo.departmentId")
    public void update(Long id,JobFo fo){
        Job job = baseMapper.selectById(id);
        Asserts.notNull(job);
        BeanUtils.copyProperties(fo,job);
        baseMapper.updateById(job);
    }

    @Override
    @SuppressWarnings("unchecked")
    public PageR<JobTo> list(JobQo qo){
        return super.toPageR(baseMapper.list(super.toPage(qo),qo));
    }

    @Override
    public JobVo get(Long id){
        return baseMapper.get(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(allEntries = true)
    public void delete(Long id){
        baseMapper.deleteById(id);
    }

    @Override
    @Cacheable(key = "#departmentId",unless = "#result == null")
    public List<So<Long>> select(Long departmentId) {
        return baseMapper.select(departmentId);
    }
}
