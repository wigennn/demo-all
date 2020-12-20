package com.redbyte.platform.demobasic.config.security;

import com.redbyte.platform.demobasic.core.dao.UserMapper;
import com.redbyte.platform.demobasic.core.domain.entity.LoginUserInfo;
import com.redbyte.platform.demobasic.core.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author wangwq
 */
@Service
public class SystemUserDetailService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.selectByUserName(s);

        LoginUserInfo result = new LoginUserInfo();

        return result;
    }
}
