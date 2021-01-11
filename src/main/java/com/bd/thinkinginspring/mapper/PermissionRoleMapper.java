package com.bd.thinkinginspring.mapper;

import com.bd.thinkinginspring.entity.PermissionRoleEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: baojing.he
 * @Date: 2021/1/9 22:04
 * @Description:
 */

@Repository
public interface PermissionRoleMapper {
    PermissionRoleEntity findByPermisionId(int permissionId);
    PermissionRoleEntity findByPermisionName(String permissionName);
    List<PermissionRoleEntity> findByRoleId(int roleId);
}
