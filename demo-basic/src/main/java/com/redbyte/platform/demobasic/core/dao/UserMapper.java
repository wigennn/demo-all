package com.redbyte.platform.demobasic.core.dao;

import com.redbyte.platform.demobasic.core.domain.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User selectByPrimaryKey(Long id);

    User selectByUserName(String userName);
}