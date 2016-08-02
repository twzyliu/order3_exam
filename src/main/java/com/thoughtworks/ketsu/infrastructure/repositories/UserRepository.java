package com.thoughtworks.ketsu.infrastructure.repositories;

import com.thoughtworks.ketsu.domain.User.User;
import com.thoughtworks.ketsu.domain.User.UserIntreface;
import com.thoughtworks.ketsu.infrastructure.mybatis.mappers.UserMapper;

import javax.inject.Inject;
import java.util.Map;

/**
 * Created by zyongliu on 16/7/28.
 */
public class UserRepository implements UserIntreface{
    @Inject
    UserMapper userMapper;

    @Override
    public void createUser(Map<String, Object> userinfo) {
        userMapper.createUser(userinfo);
    }

    @Override
    public User find_user_by_id(int userid) {
        return userMapper.find_user_by_id(userid);
    }

}
