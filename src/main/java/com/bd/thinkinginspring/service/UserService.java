package com.bd.thinkinginspring.service;

import com.bd.thinkinginspring.entity.User;

import java.util.List;

/**
 * @Author: hebj
 * @Date: 2021/1/2 10:26
 * @Description:
 */

public interface UserService {
    public User getUser(int id);

    public List<User> getAllUsers();
}
