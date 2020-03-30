package pers.yurwisher.dota2.common.base;

import pers.yurwisher.dota2.common.wrapper.CustomUserInfoDetail;

/**
 * @author yq
 * @date 2019/12/23 17:38
 * @description 自定义用户信息service
 * @since V1.0.0
 */
public interface IUserInfoService {

    /**
     * 根据用户ID获取自定义用户信息,建议缓存,更新信息时清除缓存
     * @param userId 用户ID
     * @return 用户信息
     */
    CustomUserInfoDetail getUserInfoDetail(Long userId);
}
