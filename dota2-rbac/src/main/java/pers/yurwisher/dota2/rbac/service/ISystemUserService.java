package pers.yurwisher.dota2.rbac.service;

import pers.yurwisher.dota2.common.base.BaseService;
import pers.yurwisher.dota2.common.wrapper.CurrentUserInfo;
import pers.yurwisher.dota2.rbac.entity.SystemUser;
import pers.yurwisher.dota2.rbac.pojo.fo.ResetPasswordFo;
import pers.yurwisher.dota2.rbac.pojo.fo.SystemUserRegisterFo;
import pers.yurwisher.dota2.rbac.pojo.qo.SystemUserQo;
import pers.yurwisher.dota2.rbac.pojo.to.SystemUserTo;
import pers.yurwisher.wisp.wrapper.PageR;
import pers.yurwisher.wisp.wrapper.So;

import java.util.List;

/**
 * @author yq
 * @date 2019-07-10 16:59:09
 * @description 用户
 * @since V1.0.0
 */
public interface ISystemUserService extends BaseService<SystemUser> {

    /**
     * 注册
     * @param fo 参数
     * @return SystemUser
     */
    SystemUser create(SystemUserRegisterFo fo);

    /**
     * 用户列表
     * @param qo 查询参数
     * @return 分页对象
     */
    PageR<SystemUserTo> list(SystemUserQo qo);

    /**
     * 变更密码
     * @param fo 密码参数
     */
    void changePassword(ResetPasswordFo fo);

    /**
     * 用户名是否存在
     * @param username 用户名
     * @return boolean
     */
    boolean userExist(String username);

    /**
     * 用户状态下拉框
     * @return so list
     */
    List<So<String>> userStatusSelect();

    /**
     * 根据用户名获取用户
     * @param username 用户名
     * @return 用户
     */
    SystemUser findByUsername(String username);

    /**
     * 重置密码
     * @param username 帐号
     * @param password 新密码
     */
    void resetPassword(String username, String password);

    /**
     * 用户其他信息
     * @param userId 用户ID
     * @return 用户信息
     */
    CurrentUserInfo info(Long userId);

    /**
     * 禁用用户
     * @param userId 用户ID
     */
    void disable(Long userId);
}
