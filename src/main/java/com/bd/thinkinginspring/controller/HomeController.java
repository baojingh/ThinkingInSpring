package com.bd.thinkinginspring.controller;

import com.bd.thinkinginspring.entity.UserInfoEntity;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


/**
 * @Author: baojing.he
 * @Date: 2021-01-12 15:05
 * @Description:
 */

@RestController
public class HomeController {

    private static Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @GetMapping(value = "/hello")
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
        try {
            // 进行验证，这里可以捕获异常，然后返回对应信息
            SecurityUtils.getSubject().login(usernamePasswordToken);
        } catch (UnknownAccountException e) {
            LOGGER.error(String.format("the account [%s] is incorrect", userName));
        } catch (IncorrectCredentialsException e) {
            LOGGER.error(String.format("the password [%s] is incorrect", password));
        }
        return "login succesfully";
    }

    @RequiresRoles("admin")
    @ApiOperation(value = "delete user", notes = "")
    @DeleteMapping(value = "/deleteUser")
    public String deleteUser() {
        LOGGER.info("delete user succesfully");
        return "delete user succesfully";
    }

    @RequiresPermissions("user:update")
    @PostMapping(value = "/updateUser")
    @ApiOperation(value = "update user", notes = "")
    public String updateUser() {
        LOGGER.info("update user succesfully");
        return "update user succesfully";
    }

    @RequiresAuthentication
    @GetMapping(value = "/logout")
    public String logout() {
        LOGGER.info("logout succesfully");
        return "logout";
    }


    @RequiresUser
    @GetMapping(value = "/error")
    public String error() {
        LOGGER.info("error occurs");
        return "error";
    }

    @GetMapping(value = "/index")
    public String index() {
        LOGGER.info("index occurs");
        return "index";
    }

}
