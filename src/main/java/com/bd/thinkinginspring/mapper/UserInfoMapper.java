package com.bd.thinkinginspring.mapper;

import com.bd.thinkinginspring.entity.UserInfoEntity;
import org.springframework.stereotype.Repository;

/**
 * @Author: baojing.he
 * @Date: 2021/1/9 22:03
 * @Description:
 */
@Repository
public interface UserInfoMapper {
    UserInfoEntity findByName(String userName);
    UserInfoEntity findById(int id);
}
