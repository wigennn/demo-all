package com.redbyte.platform.demobasic.core.domain.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author wangwq
 */
@Data
public class LoginUserInfo implements UserDetails {

    private Long id;

    private String userName;

    private String password;

    private String name;

    private String phone;

    private Long roleId;

    private Boolean isAdmin;

    private Byte status;

    private Date createTime;

    private Date updateTime;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return status == 0;
    }
}
