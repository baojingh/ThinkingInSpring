package com.bd.thinkinginspring.mapper;

import com.bd.thinkinginspring.entity.RoleInfoEntity;
import org.springframework.stereotype.Repository;

/**
 * @Author: baojing.he
 * @Date: 2021/1/9 22:03
 * @Description:
 */
@Repository
public interface RoleInfoMapper {
    RoleInfoEntity findByName(String roleName);
    RoleInfoEntity findById(int id);
}
