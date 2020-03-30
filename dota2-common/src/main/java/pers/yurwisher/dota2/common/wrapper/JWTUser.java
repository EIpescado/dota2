package pers.yurwisher.dota2.common.wrapper;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import pers.yurwisher.dota2.common.enums.tip.RBACCustomTipEnum;
import pers.yurwisher.dota2.common.exception.RBACException;
import pers.yurwisher.wisp.utils.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yq
 * @date 2019/07/12 11:15
 * @description JWT user
 * @since V1.0.0
 */
public class JWTUser implements UserDetails {

    private static final long serialVersionUID = -6103146019097743639L;
    /**
     * 用户ID
     */
    private Long id;
    private String username;
    /**
     * 代理级别
     */
    private String password;
    private List<String> roles;
    private Collection<GrantedAuthority> authorities;

    public JWTUser() {
    }

    public JWTUser(Long id, String username,String password,List<String> roles, List<String> permissions) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.authorities = CollectionUtils.isNotEmpty(permissions)? permissions.stream().map(p -> new SimpleGrantedAuthority(p)).collect(Collectors.toList()) : null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JSONField(serialize = false)
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JSONField(serialize = false)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JSONField(serialize = false)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JSONField(serialize = false)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public List<String> getRoles() {
        return roles;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public static JWTUser current() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal == null) {
            throw new RBACException(RBACCustomTipEnum.LOGIN_EXPIRED);
        } else {
            //匿名用户
            if (principal instanceof String) {
                throw new RBACException(RBACCustomTipEnum.LOGIN_EXPIRED);
            }
            return (JWTUser) principal;
        }
    }

    public static Long currentUserId(){
        return current().getId();
    }

}
