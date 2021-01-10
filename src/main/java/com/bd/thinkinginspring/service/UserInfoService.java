package com.bd.thinkinginspring.service;

import com.bd.thinkinginspring.entity.UserInfoEntity;

/**
 * @Author: baojing.he
 * @Date: 2021/1/9 22:22
 * @Description:
 */
public interface UserInfoService {
    UserInfoEntity findByName(String userName);
    UserInfoEntity findById(int id);
}
