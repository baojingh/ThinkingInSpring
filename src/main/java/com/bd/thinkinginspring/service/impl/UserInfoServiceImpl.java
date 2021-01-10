package com.bd.thinkinginspring.service.impl;

import com.bd.thinkinginspring.entity.UserInfoEntity;
import com.bd.thinkinginspring.mapper.UserInfoMapper;
import com.bd.thinkinginspring.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: baojing.he
 * @Date: 2021/1/9 22:24
 * @Description:
 */

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfoEntity findByName(String userName) {
        return userInfoMapper.findByName(userName);
    }

    @Override
    public UserInfoEntity findById(int id) {
        return userInfoMapper.findById(id);
    }
}
