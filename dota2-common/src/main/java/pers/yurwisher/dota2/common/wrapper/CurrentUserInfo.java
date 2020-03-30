package pers.yurwisher.dota2.common.wrapper;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author yq
 * @date 2019/11/09 17:10
 * @description 当前用户其他信息
 * @since V1.0.0
 */
@Data
public class CurrentUserInfo implements Serializable {
    private static final long serialVersionUID = -237700675653726845L;

    private Long id;
    private String username;
    private List<String> roles;
    private CustomUserInfoDetail detail;
}
