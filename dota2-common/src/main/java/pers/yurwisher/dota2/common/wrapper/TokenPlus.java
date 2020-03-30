package pers.yurwisher.dota2.common.wrapper;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pers.yurwisher.token.Token;

import java.util.List;

/**
 * @author yq
 * @date 2019/07/15 12:24
 * @description 自定义token
 * @since V1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TokenPlus extends Token {

    private Long id;
    @JSONField(name = "rs")
    private List<String> roles;
    @JSONField(name = "lup")
    private Long lastUpdatePassword;

    /**
     * 请求token转化为JWTUser
     * @return JWTUser
     */
    public JWTUser toJWTUser(){
        JWTUser user = new JWTUser();
        user.setId(this.id);
        user.setUsername(super.getUserName());
        user.setRoles(this.roles);
        return user;
    }
}
