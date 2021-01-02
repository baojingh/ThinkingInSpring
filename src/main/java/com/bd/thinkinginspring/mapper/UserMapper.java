package com.bd.thinkinginspring.mapper;

import com.bd.thinkinginspring.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: hebj
 * @Date: 2021/1/2 10:25
 * @Description:
 */

@Repository
public interface UserMapper {
    User getUser(int id);

    List<User> getAllUsers();
}
