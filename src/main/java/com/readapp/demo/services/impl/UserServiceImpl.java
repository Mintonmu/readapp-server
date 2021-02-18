package com.readapp.demo.services.impl;

import com.readapp.demo.common.Result;
import com.readapp.demo.entity.User;
import com.readapp.demo.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {


    @Override
    public Result<User> create(User user) {
        return null;
    }

    @Override
    public Boolean deleteUser(User user) {
        return null;
    }

    @Override
    public Result<User> updateUser(User user) {
        return null;
    }

    @Override
    public Result<User> findByOpenId(String openId) {
        return null;
    }
}
