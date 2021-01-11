package com.bd.thinkinginspring.mapper;

import com.bd.thinkinginspring.entity.UserRoleEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: baojing.he
 * @Date: 2021/1/9 22:04
 * @Description:
 */

@Repository
public interface UserRoleMapper {
    UserRoleEntity findById(int id);
    UserRoleEntity findByUserId(int userId);
    List<UserRoleEntity> findByRoleId(int roleId);
    List<UserRoleEntity> findRoleList(int userId);
}
