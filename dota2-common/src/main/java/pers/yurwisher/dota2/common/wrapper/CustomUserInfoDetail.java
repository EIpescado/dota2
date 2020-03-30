package pers.yurwisher.dota2.common.wrapper;

import lombok.Data;

/**
 * @author yq
 * @date 2019/12/20 14:17
 * @description 自身系统需要的用户信息,如昵称,头像
 * @since V1.0.0
 */
@Data
public class CustomUserInfoDetail {
    private static final long serialVersionUID = -3854884318374675071L;

    private String nickName;
    private String avatar;
}
