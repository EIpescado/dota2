package pers.yurwisher.dota2.rbac.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.yurwisher.dota2.common.base.impl.BaseServiceImpl;
import pers.yurwisher.dota2.rbac.entity.RoleButton;
import pers.yurwisher.dota2.rbac.mapper.RoleButtonMapper;
import pers.yurwisher.dota2.rbac.service.IRoleButtonService;
import pers.yurwisher.wisp.utils.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色按钮关联表 服务实现类
 * </p>
 *
 * @author yq
 * @since 2019-07-10
 */
@Service
public class RoleButtonServiceImpl extends BaseServiceImpl<RoleButtonMapper, RoleButton> implements IRoleButtonService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void bind(Long roleId, List<Long> buttonIds) {
        if(CollectionUtils.isNotEmpty(buttonIds)){
            //删除之前
            baseMapper.deleteByRoleId(roleId);
            //绑定
            List<RoleButton> roleButtons = buttonIds.stream().map(bid ->{
                RoleButton rb = new RoleButton();
                rb.setButtonId(bid);
                rb.setRoleId(roleId);
                return rb;
            }).collect(Collectors.toList());
            super.saveBatch(roleButtons);
        }
    }
}
