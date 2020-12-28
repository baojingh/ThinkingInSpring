package com.bd.thinkinginspring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hebj
 * @Date: 2020/12/26 00:21
 * @Description:
 */

@RestController
public class UserHelloWorldController {

    private static Logger LOGGER = LoggerFactory.getLogger(UserHelloWorldController.class);


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getUserById() {
        LOGGER.info("hello world 何保敬");
        System.out.println("****************");
        return "helloworld";
    }

}
