package pers.yurwisher.dota2.common.wrapper;

import java.util.List;

public class JWTUserBuilder {
    private Long id;
    private String username;
    private String password;
    private List<String> roles;
    private List<String> permissions;

    public JWTUserBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public JWTUserBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public JWTUserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public JWTUserBuilder setRoles(List<String> roles) {
        this.roles = roles;
        return this;
    }

    public JWTUserBuilder setPermissions(List<String> permissions) {
        this.permissions = permissions;
        return this;
    }

    public JWTUser build() {
        return new JWTUser(id, username,password, roles, permissions);
    }
}
