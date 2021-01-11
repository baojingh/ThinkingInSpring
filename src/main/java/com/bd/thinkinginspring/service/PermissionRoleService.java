package com.bd.thinkinginspring.service;

import com.bd.thinkinginspring.entity.PermissionRoleEntity;

import java.util.List;

/**
 * @Author: baojing.he
 * @Date: 2021/1/9 22:23
 * @Description:
 */
public interface PermissionRoleService {
    PermissionRoleEntity findByPermisionId(int permissionId);

    PermissionRoleEntity findByPermisionName(String permissionName);

    List<PermissionRoleEntity> findByRoleId(int roleId);
}
