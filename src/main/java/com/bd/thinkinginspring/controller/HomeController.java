package com.bd.thinkinginspring.controller;

import com.bd.thinkinginspring.entity.UserInfoEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


/**
 * @Author: baojing.he
 * @Date: 2021-01-12 15:05
 * @Description:
 */

@Api(value = "/user")
@RestController
public class HomeController {

    private static Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ApiOperation(value = "hello test", notes = "")
    public String hello() {
        // 添加用户认证信息
        LOGGER.info("hello world");
        return "hello world successfully";
    }

    @PostMapping(value = "/login")
    @ApiOperation(value = "user login", notes = "")
    public String login(@RequestBody UserInfoEntity user) {
        // 添加用户认证信息
        String userName = user.getUserName();
        String password = user.getPassword();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, password);
        LOGGER.info(String.format("user [%s] login and password [%s]", userName, password));
        // 进行验证，这里可以捕获异常，然后返回对应信息
        SecurityUtils.getSubject().login(usernamePasswordToken);
        return "login succesfully";
    }
}
