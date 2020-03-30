package pers.yurwisher.dota2.rbac.mapper;

import org.apache.ibatis.annotations.Param;
import pers.yurwisher.dota2.common.base.CommonMapper;
import pers.yurwisher.dota2.rbac.entity.UserRole;

/**
 * <p>
 * 用户角色关联表 Mapper 接口
 * </p>
 *
 * @author yq
 * @since 2019-07-10
 */
public interface UserRoleMapper extends CommonMapper<UserRole> {

    /**
     * 删除
     * @param userId 用户id
     */
    void deleteByUserId(@Param("userId") Long userId);
}
