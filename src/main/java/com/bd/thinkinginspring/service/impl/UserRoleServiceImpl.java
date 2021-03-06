package com.bd.thinkinginspring.service.impl;

import com.bd.thinkinginspring.entity.UserRoleEntity;
import com.bd.thinkinginspring.mapper.UserRoleMapper;
import com.bd.thinkinginspring.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: baojing.he
 * @Date: 2021/1/9 22:24
 * @Description:
 */

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public UserRoleEntity findById(int id) {
        return userRoleMapper.findById(id);
    }

    @Override
    public UserRoleEntity findByUserId(int userId) {
        return userRoleMapper.findByUserId(userId);
    }

    @Override
    public List<UserRoleEntity> findByRoleId(int roleId) {
        return userRoleMapper.findByRoleId(roleId);
    }

    @Override
    public List<UserRoleEntity> findRoleList(int userId) {
        return userRoleMapper.findRoleList(userId);
    }
}
