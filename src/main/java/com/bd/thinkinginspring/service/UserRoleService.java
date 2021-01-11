package com.bd.thinkinginspring.service;

import com.bd.thinkinginspring.entity.UserRoleEntity;

import java.util.List;

/**
 * @Author: baojing.he
 * @Date: 2021/1/9 22:23
 * @Description:
 */
public interface UserRoleService {
    UserRoleEntity findById(int id);
    UserRoleEntity findByUserId(int userId);
    List<UserRoleEntity> findByRoleId(int roleId);
    List<UserRoleEntity> findRoleList(int userId);
}
