package pers.yurwisher.dota2.rbac.pojo.fo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yq
 * @date 2019/07/12 14:18
 * @description 登录参数
 * @since V1.0.0
 */
@Data
public class LoginParams implements Serializable {
    private static final long serialVersionUID = 4483964571196267547L;

    private String username;
    private String password;
    private String validCode;
    private String uuid;
}
