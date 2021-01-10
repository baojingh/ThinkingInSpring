package com.bd.thinkinginspring.service;

import com.bd.thinkinginspring.entity.RoleInfoEntity;

/**
 * @Author: baojing.he
 * @Date: 2021/1/9 22:22
 * @Description:
 */
public interface RoleInfoService {
    RoleInfoEntity findByName(String roleName);
    RoleInfoEntity findById(int id);
}
