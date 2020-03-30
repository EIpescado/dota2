package pers.yurwisher.dota2.rbac.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import pers.yurwisher.dota2.common.base.CommonMapper;
import pers.yurwisher.dota2.rbac.entity.SystemRole;
import pers.yurwisher.dota2.rbac.pojo.qo.SystemRoleQo;
import pers.yurwisher.dota2.rbac.pojo.to.SystemRoleTo;
import pers.yurwisher.dota2.rbac.pojo.vo.SystemRoleVo;
import pers.yurwisher.wisp.wrapper.So;

import java.util.List;

/**
 * @author yq
 * @date 2019-07-11 16:38:43
 * @description 角色 Mapper
 * @since V1.0.0
 */
public interface SystemRoleMapper extends CommonMapper<SystemRole> {

    /**
     * 列表
     * @param page mybatis-plus分页参数
     * @param qo 查询参数
     * @return 列表
     */
    IPage<SystemRoleTo> list(Page page, @Param("qo") SystemRoleQo qo);

    /**
    * 详情
    * @param id ID
    * @return 详情
    */
    SystemRoleVo get(@Param("id") Long id);

    /**
     * 获取用户角色
     * @param userName 用户名
     * @return 角色集合
     */
    List<SystemRole> getRoles(@Param("userName") String userName);

    /**
     * 角色下拉框
     * @return list
     */
    List<So<Long>> select();

    /**
     * 获取用户角色
     * @param userId 用户ID
     * @return 角色集合
     */
    List<String> getRolesByUserId(@Param("userId") Long userId);
}
