package com.bd.thinkinginspring.mapper;

import com.bd.thinkinginspring.entity.UserInfoEntity;

/**
 * @Author: baojing.he
 * @Date: 2021/1/9 22:03
 * @Description:
 */
public interface UserInfoMapper {
    UserInfoEntity findByName(String userName);
}
