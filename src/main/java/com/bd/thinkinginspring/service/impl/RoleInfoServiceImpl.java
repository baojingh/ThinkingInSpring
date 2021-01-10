package com.bd.thinkinginspring.service.impl;

import com.bd.thinkinginspring.entity.RoleInfoEntity;
import com.bd.thinkinginspring.mapper.RoleInfoMapper;
import com.bd.thinkinginspring.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: baojing.he
 * @Date: 2021/1/9 22:24
 * @Description:
 */

@Service
public class RoleInfoServiceImpl implements RoleInfoService {

    @Autowired
    private RoleInfoMapper roleInfoMapper;

    @Override
    public RoleInfoEntity findByName(String roleName) {
        return roleInfoMapper.findByName(roleName);
    }

    @Override
    public RoleInfoEntity findById(int id) {
        return roleInfoMapper.findById(id);
    }
}
