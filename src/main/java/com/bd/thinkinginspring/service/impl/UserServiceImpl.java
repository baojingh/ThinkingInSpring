package com.bd.thinkinginspring.service.impl;

import com.bd.thinkinginspring.entity.User;
import com.bd.thinkinginspring.mapper.UserMapper;
import com.bd.thinkinginspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: hebj
 * @Date: 2021/1/2 10:25
 * @Description:
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(int id) {
        return userMapper.getUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
}
