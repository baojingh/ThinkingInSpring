package com.bd.thinkinginspring.controller;

import com.bd.thinkinginspring.entity.User;
import com.bd.thinkinginspring.service.UserService;
import com.bd.thinkinginspring.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: hebj
 * @Date: 2020/12/26 00:21
 * @Description:
 */

@RestController
public class UserController {

    private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userService;


    @RequestMapping(value = "getUser/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable int id) {
        LOGGER.info("hello world 何保敬");
        return userService.getUser(id);
    }

    @RequestMapping(value = "getAllUsers/", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        LOGGER.info("hello world 何保敬");
        return userService.getAllUsers();
    }

}
