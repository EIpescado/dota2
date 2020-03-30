package pers.yurwisher.dota2.rbac.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.yurwisher.dota2.common.base.impl.BaseServiceImpl;
import pers.yurwisher.dota2.common.constant.cache.RBACCacheConstant;
import pers.yurwisher.dota2.rbac.entity.Menu;
import pers.yurwisher.dota2.rbac.mapper.MenuMapper;
import pers.yurwisher.dota2.rbac.pojo.dto.ButtonDto;
import pers.yurwisher.dota2.rbac.pojo.dto.MenuNode;
import pers.yurwisher.dota2.rbac.pojo.dto.TreeNode;
import pers.yurwisher.dota2.rbac.pojo.fo.MenuFo;
import pers.yurwisher.dota2.rbac.pojo.vo.MenuVo;
import pers.yurwisher.dota2.rbac.service.IButtonService;
import pers.yurwisher.dota2.rbac.service.IMenuService;
import pers.yurwisher.wisp.utils.Asserts;
import pers.yurwisher.wisp.utils.CollectionUtils;
import pers.yurwisher.wisp.wrapper.Tree;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yq
 * @date 2019-07-11 16:34:49
 * @description 菜单
 * @since V1.0.0
 */
@Service
@CacheConfig(cacheNames = RBACCacheConstant.NEVER_EXPIRE_CACHE )
public class MenuServiceImpl extends BaseServiceImpl<MenuMapper, Menu> implements IMenuService {

    private IButtonService buttonService;

    public MenuServiceImpl(IButtonService buttonService) {
        this.buttonService = buttonService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Caching(evict = {
        @CacheEvict(key = "T(pers.yurwisher.dota2.common.constant.cache.keys.RBACKey).FULL_TREE"),
    })
    public void create(MenuFo fo) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(fo, menu);
        baseMapper.insert(menu);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Caching(evict = {
            @CacheEvict(key = "T(pers.yurwisher.dota2.common.constant.cache.keys.RBACKey).FULL_TREE"),
            @CacheEvict(value = RBACCacheConstant.USER_MENU_TREE,allEntries = true)
    })
    public void update(Long id, MenuFo fo) {
        Menu menu = baseMapper.selectById(id);
        Asserts.notNull(menu);
        BeanUtils.copyProperties(fo, menu);
        baseMapper.updateById(menu);
    }

    @Override
    public MenuVo get(Long id) {
        return baseMapper.get(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Caching(evict = {
            @CacheEvict(key = "T(pers.yurwisher.dota2.common.constant.cache.keys.RBACKey).FULL_TREE"),
            @CacheEvict(value = RBACCacheConstant.USER_MENU_TREE,allEntries = true)
    })
    public void delete(Long id) {
        baseMapper.deleteById(id);
    }

    @Override
    @Cacheable(value = RBACCacheConstant.USER_MENU_TREE, key = "#userId",unless = "#result == null")
    public List<MenuNode> tree(Long userId) {
        return buildTree(baseMapper.findAllByUserId(userId), buttonService.findAllByUserId(userId));
    }

    @Override
    @Cacheable(key = "T(pers.yurwisher.dota2.common.constant.cache.keys.RBACKey).FULL_TREE",unless = "#result == null")
    public List<TreeNode> fullTree() {
        List<TreeNode> menuNodes = baseMapper.findAllForFullTree();
        List<TreeNode> buttonNodes = buttonService.allButton();
        if (CollectionUtils.isNotEmpty(menuNodes) && CollectionUtils.isNotEmpty(buttonNodes)) {
            menuNodes.addAll(buttonNodes);
        }
        return new Tree<Long,TreeNode>(-1L).build(menuNodes);
    }

    @Override
    public List<Long> singleRoleMenu(Long roleId) {
        return baseMapper.findAllByRoleId(roleId);
    }

    /**
     * 构建树
     *
     * @param list       所有菜单集合
     * @param buttonList 按钮集合
     * @return 构建好的集合
     */
    private List<MenuNode> buildTree(List<MenuNode> list, List<ButtonDto> buttonList) {
        Map<Long, List<ButtonDto>> buttonMap = null;
        if (CollectionUtils.isNotEmpty(buttonList)) {
            buttonMap = buttonList.stream().collect(Collectors.groupingBy(ButtonDto::getMenuId));
        }
        if (CollectionUtils.isNotEmpty(list)) {
            if (CollectionUtils.isNotEmpty(buttonMap)) {
                for (MenuNode menu : list) {
                    //此菜单下的所有按钮
                    List<ButtonDto> buttons = buttonMap.get(menu.getId());
                    if (CollectionUtils.isNotEmpty(buttons)) {
                        //按按钮位置分组
                        menu.setButtons(buttons.stream().collect(Collectors.groupingBy(ButtonDto::getPosition)));
                    }
                }
            }
            return new Tree<Long,MenuNode>(-1L).build(list);
        }
        return null;
    }


}
