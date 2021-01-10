package com.bd.thinkinginspring.service;

import com.bd.thinkinginspring.entity.PermissionRoleEntity;

/**
 * @Author: baojing.he
 * @Date: 2021/1/9 22:23
 * @Description:
 */
public interface PermissionRoleService {
    PermissionRoleEntity findByPermisionId(int permissionId);

    PermissionRoleEntity findByPermisionName(String permissionName);

    PermissionRoleEntity findByRoleId(int roleId);
}
