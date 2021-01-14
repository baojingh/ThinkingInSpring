package com.bd.thinkinginspring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: hebj
 * @Date: 2020/12/24 20:22
 * @Description:
 */

@SpringBootApplication
public class ThinkingInSpringApplication {

    /**
     * 重点参考如下文章：
     * https://www.cnblogs.com/xifengxiaoma/p/11061142.html
     *
     *
     *
     * springboot集成shiro
     * https://segmentfault.com/a/1190000014479154
     *
     * 官网springboot+shiro
     * https://shiro.apache.org/spring-boot.html
     *
     */

    public static void main(String[] args) {
        SpringApplication.run(ThinkingInSpringApplication.class, args);
    }
}
