package pers.yurwisher.dota2.rbac.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import pers.yurwisher.dota2.common.base.CommonMapper;
import pers.yurwisher.dota2.common.enums.UserStatusEnum;
import pers.yurwisher.dota2.rbac.entity.SystemUser;
import pers.yurwisher.dota2.rbac.pojo.qo.SystemUserQo;
import pers.yurwisher.dota2.rbac.pojo.to.SystemUserTo;

import java.time.LocalDateTime;

/**
 * <p>
 * 系统用户 Mapper 接口
 * </p>
 *
 * @author yq
 * @since 2019-07-10
 */
public interface SystemUserMapper extends CommonMapper<SystemUser> {

    /**
     * 内部用户列表
     * @param page mybatis-plus分页参数
     * @param qo 查询参数
     * @return 列表
     */
    IPage<SystemUserTo> list(Page page, @Param("qo") SystemUserQo qo);

    /**
     * 根据用户名更新密码
     * @param username 用户名
     * @param newPassword 新密码
     * @param currentTime 时间
     */
    void updatePasswordByUsername(@Param("username")String username,
                                  @Param("newPassword") String newPassword,
                                  @Param("currentTime") LocalDateTime currentTime);

    /**
     * 根据用户名和密码汇总
     * @param username 用户名
     * @param password 密码 可为null
     * @return count
     */
    Integer countByUserNameAndPassword(@Param("username") String username, @Param("password") String password);

    /**
     * 根据ID修改用户状态
     * @param id ID
     * @param status 状态
     */
    void updateStatusById(@Param("id")Long id, @Param("status") UserStatusEnum status);

}
