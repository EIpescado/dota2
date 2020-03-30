package pers.yurwisher.dota2.rbac.mapper;

import org.apache.ibatis.annotations.Param;
import pers.yurwisher.dota2.common.base.CommonMapper;
import pers.yurwisher.dota2.rbac.entity.RoleButton;

/**
 * <p>
 * 角色按钮关联表 Mapper 接口
 * </p>
 *
 * @author yq
 * @since 2019-07-10
 */
public interface RoleButtonMapper extends CommonMapper<RoleButton> {

    /**
     * 删除
     * @param roleId 角色id
     */
    void deleteByRoleId(@Param("roleId") Long roleId);
}
