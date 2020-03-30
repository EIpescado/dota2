package pers.yurwisher.dota2.rbac.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.yurwisher.dota2.common.base.impl.BaseServiceImpl;
import pers.yurwisher.dota2.common.constant.cache.RBACCacheConstant;
import pers.yurwisher.dota2.rbac.entity.Department;
import pers.yurwisher.dota2.rbac.mapper.DepartmentMapper;
import pers.yurwisher.dota2.rbac.pojo.dto.DepartmentNode;
import pers.yurwisher.dota2.rbac.pojo.fo.DepartmentFo;
import pers.yurwisher.dota2.rbac.pojo.vo.DepartmentVo;
import pers.yurwisher.dota2.rbac.service.IDepartmentService;
import pers.yurwisher.wisp.utils.Asserts;
import pers.yurwisher.wisp.wrapper.Tree;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author yq
 * @date 2019-07-22 17:11:02
 * @description 部门
 * @since V1.0.0
 */
@Service
@CacheConfig(cacheNames = RBACCacheConstant.NEVER_EXPIRE_CACHE )
public class DepartmentServiceImpl extends BaseServiceImpl<DepartmentMapper,Department> implements IDepartmentService{

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(key = "T(pers.yurwisher.dota2.common.constant.cache.keys.RBACKey).DEPARTMENT_TREE")
    public void create(DepartmentFo fo){
        Department department = new Department();
        BeanUtils.copyProperties(fo,department);
        department.setDateCreated(LocalDateTime.now());
        department.setEnabled(true);
        baseMapper.insert(department);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(key = "T(pers.yurwisher.dota2.common.constant.cache.keys.RBACKey).DEPARTMENT_TREE")
    public void update(Long id,DepartmentFo fo){
        Department department = baseMapper.selectById(id);
        Asserts.notNull(department);
        BeanUtils.copyProperties(fo,department);
        baseMapper.updateById(department);
    }

    @Override
    public DepartmentVo get(Long id){
        return baseMapper.get(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(key = "T(pers.yurwisher.dota2.common.constant.cache.keys.RBACKey).DEPARTMENT_TREE")
    public void delete(Long id){
        baseMapper.deleteById(id);
    }

    @Override
    @Cacheable(key = "T(pers.yurwisher.dota2.common.constant.cache.keys.RBACKey).DEPARTMENT_TREE",unless = "#result == null")
    public List<DepartmentNode> tree() {
        List<DepartmentNode> list = baseMapper.findAll();
        return new Tree<Long,DepartmentNode>(-1L).build(list);
    }
}
