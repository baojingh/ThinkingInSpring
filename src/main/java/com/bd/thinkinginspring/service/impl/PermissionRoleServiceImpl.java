package com.bd.thinkinginspring.service.impl;

import com.bd.thinkinginspring.entity.PermissionRoleEntity;
import com.bd.thinkinginspring.mapper.PermissionRoleMapper;
import com.bd.thinkinginspring.service.PermissionRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: baojing.he
 * @Date: 2021/1/9 22:25
 * @Description:
 */
@Service
public class PermissionRoleServiceImpl implements PermissionRoleService {

    @Autowired
    private PermissionRoleMapper permissionRoleMapper;


    @Override
    public PermissionRoleEntity findByPermisionId(int permissionId) {
        return permissionRoleMapper.findByPermisionId(permissionId);
    }

    @Override
    public PermissionRoleEntity findByPermisionName(String permissionName) {
        return permissionRoleMapper.findByPermisionName(permissionName);
    }

    @Override
    public PermissionRoleEntity findByRoleId(int roleId) {
        return permissionRoleMapper.findByRoleId(roleId);
    }
}
