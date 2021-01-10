package com.bd.thinkinginspring.service;

import com.bd.thinkinginspring.entity.UserRoleEntity;

/**
 * @Author: baojing.he
 * @Date: 2021/1/9 22:23
 * @Description:
 */
public interface UserRoleService {
    UserRoleEntity findById(int id);
    UserRoleEntity findByUserId(String userId);
    UserRoleEntity findByRoleId(int roleId);
}
