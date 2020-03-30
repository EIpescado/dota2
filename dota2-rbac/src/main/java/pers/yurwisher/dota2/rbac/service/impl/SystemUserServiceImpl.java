package pers.yurwisher.dota2.rbac.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.yurwisher.dota2.common.base.IUserInfoService;
import pers.yurwisher.dota2.common.base.impl.BaseServiceImpl;
import pers.yurwisher.dota2.common.constant.SystemConstant;
import pers.yurwisher.dota2.common.constant.cache.RBACCacheConstant;
import pers.yurwisher.dota2.common.enums.UserStatusEnum;
import pers.yurwisher.dota2.common.enums.tip.RBACCustomTipEnum;
import pers.yurwisher.dota2.common.exception.RBACException;
import pers.yurwisher.dota2.common.utils.Utils;
import pers.yurwisher.dota2.common.wrapper.CurrentUserInfo;
import pers.yurwisher.dota2.common.wrapper.CustomUserInfoDetail;
import pers.yurwisher.dota2.common.wrapper.JWTUser;
import pers.yurwisher.dota2.rbac.entity.SystemUser;
import pers.yurwisher.dota2.rbac.mapper.SystemUserMapper;
import pers.yurwisher.dota2.rbac.pojo.fo.ResetPasswordFo;
import pers.yurwisher.dota2.rbac.pojo.fo.SystemUserRegisterFo;
import pers.yurwisher.dota2.rbac.pojo.qo.SystemUserQo;
import pers.yurwisher.dota2.rbac.pojo.to.SystemUserTo;
import pers.yurwisher.dota2.rbac.service.ISystemUserService;
import pers.yurwisher.dota2.rbac.service.IUserRoleService;
import pers.yurwisher.wisp.wrapper.PageR;
import pers.yurwisher.wisp.wrapper.So;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yq
 * @date 2019-07-10 16:59:09
 * @description 用户
 * @since V1.0.0
 */
@Service
public class SystemUserServiceImpl extends BaseServiceImpl<SystemUserMapper, SystemUser> implements ISystemUserService {

    private IUserRoleService userRoleService;
    private IUserInfoService userInfoService;

    public SystemUserServiceImpl(IUserRoleService userRoleService, IUserInfoService userInfoService) {
        this.userRoleService = userRoleService;
        this.userInfoService = userInfoService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SystemUser create(SystemUserRegisterFo fo) {
        //用户名已被使用
        if (userExist(fo.getUsername())) {
            throw new RBACException(RBACCustomTipEnum.USER_NAME_HAVE_BEEN_USED);
        }
        SystemUser user = new SystemUser();
        user.setUsername(fo.getUsername());
        user.setRegisterDate(LocalDateTime.now());
        //正常
        user.setStatus(UserStatusEnum.NORMAL);
        user.setPassword(Utils.encryptPassword(fo.getPassword()));
        baseMapper.insert(user);
        //绑定注册默认角色
        userRoleService.bindRole(user.getId(), Collections.singletonList(SystemConstant.REGISTER_USER_DEFAULT_ROLE_ID));
        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public PageR<SystemUserTo> list(SystemUserQo qo) {
        return super.toPageR(baseMapper.list(super.toPage(qo), qo));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void disable(Long userId) {
        baseMapper.updateStatusById(userId, UserStatusEnum.DISABLED);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void changePassword(ResetPasswordFo fo) {
        //校验2次密码是否一致
        if (!fo.getNewPassword().equals(fo.getReEnterNewPassword())) {
            throw new RBACException(RBACCustomTipEnum.TWO_PASSWORD_IN_CONFORMITY);
        }
        String username = JWTUser.current().getUsername();
        //根据用户名,密码查找用户
        Integer count = baseMapper.countByUserNameAndPassword(username, fo.getOriginalPassword());
        if (count != null && count != 0) {
            baseMapper.updatePasswordByUsername(username, Utils.encryptPassword(fo.getNewPassword()), LocalDateTime.now());
        } else {
            throw new RBACException(RBACCustomTipEnum.USER_NAME_OR_PASSWORD_ERROR);
        }
    }

    @Override
    public boolean userExist(String username) {
        Integer count = baseMapper.countByUserNameAndPassword(username, null);
        return count != null && count != 0;
    }

    @Override
    @Cacheable(value = RBACCacheConstant.SELECT, key = "T(pers.yurwisher.dota2.common.constant.cache.keys.RBACKey).USER_STATUS_SELECT", unless = "#result == null")
    public List<So<String>> userStatusSelect() {
        return Arrays.stream(UserStatusEnum.values()).map(e -> new So<>(e.getDesc(), e.name())).collect(Collectors.toList());
    }

    @Override
    public SystemUser findByUsername(String username) {
        return baseMapper.selectOne(super.buildLambdaQueryWrapper().eq(SystemUser::getUsername, username));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void resetPassword(String username, String password) {
        baseMapper.updatePasswordByUsername(username, Utils.encryptPassword(password), LocalDateTime.now());
    }

    @Override
    public CurrentUserInfo info(Long userId) {
        CurrentUserInfo info = new CurrentUserInfo();
        JWTUser user = JWTUser.current();
        info.setRoles(user.getRoles());
        info.setId(user.getId());
        info.setUsername(user.getUsername());
        info.setDetail(userInfoService.getUserInfoDetail(userId));
        return info;
    }

    //@Cacheable(value = RBACCacheConstant.CUSTOM_USER_INFO, key = "#userId",unless = "#result == null")
    //public CustomUserInfoDetail getUserInfoDetail(Long userId){
    //    logger.info("获取用户自定义信息....");
    //    return null;
    //}


}
