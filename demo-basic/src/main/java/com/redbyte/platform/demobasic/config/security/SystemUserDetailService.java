package com.redbyte.platform.demobasic.config.security;

import com.redbyte.platform.demobasic.core.domain.entity.LoginUserInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author wangwq
 */
@Service
public class SystemUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        return new LoginUserInfo();
    }
}
