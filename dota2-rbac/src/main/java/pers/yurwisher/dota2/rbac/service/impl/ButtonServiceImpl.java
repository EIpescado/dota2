package pers.yurwisher.dota2.rbac.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.yurwisher.dota2.common.base.impl.BaseServiceImpl;
import pers.yurwisher.dota2.common.constant.cache.RBACCacheConstant;
import pers.yurwisher.dota2.rbac.entity.Button;
import pers.yurwisher.dota2.rbac.mapper.ButtonMapper;
import pers.yurwisher.dota2.rbac.pojo.dto.ButtonDto;
import pers.yurwisher.dota2.rbac.pojo.dto.TreeNode;
import pers.yurwisher.dota2.rbac.pojo.fo.ButtonFo;
import pers.yurwisher.dota2.rbac.pojo.vo.ButtonVo;
import pers.yurwisher.dota2.rbac.service.IButtonService;
import pers.yurwisher.wisp.utils.Asserts;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author yq
 * @date 2019-07-11 16:39:42
 * @description 按钮
 * @since V1.0.0
 */
@Service
@CacheConfig(cacheNames = RBACCacheConstant.NEVER_EXPIRE_CACHE )
public class ButtonServiceImpl extends BaseServiceImpl<ButtonMapper,Button> implements IButtonService{

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Caching(evict = {
        @CacheEvict(key = "T(pers.yurwisher.dota2.common.constant.cache.keys.RBACKey).FULL_TREE")
    })
    public void create(ButtonFo fo){
        Button button = new Button();
        BeanUtils.copyProperties(fo,button);
        button.setEnabled(true);
        button.setDateCreated(LocalDateTime.now());
        baseMapper.insert(button);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Caching(evict = {
            @CacheEvict(key = "T(pers.yurwisher.dota2.common.constant.cache.keys.RBACKey).FULL_TREE"),
            @CacheEvict(value = RBACCacheConstant.USER_MENU_TREE,allEntries = true)
    })
    public void update(Long id,ButtonFo fo){
        Button button = baseMapper.selectById(id);
        Asserts.notNull(button);
        BeanUtils.copyProperties(fo,button);
        baseMapper.updateById(button);
    }

    @Override
    public ButtonVo get(Long id){
        return baseMapper.get(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Caching(evict = {
            @CacheEvict(key = "T(pers.yurwisher.dota2.common.constant.cache.keys.RBACKey).FULL_TREE"),
            @CacheEvict(value = RBACCacheConstant.USER_MENU_TREE,allEntries = true)
    })
    public void delete(Long id){
        baseMapper.deleteById(id);
    }

    @Override
    public List<TreeNode> allButton(){
        return baseMapper.allButton();
    }

    @Override
    public List<Long> singleRoleButton(Long roleId) {
        return baseMapper.findAllButtonIdByRoleId(roleId);
    }

    @Override
    public List<ButtonDto> findAllByUserId(Long userId) {
        return baseMapper.findAllByUserId(userId);
    }
}
