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
@MapperScan(value = "com.bd.thinkinginspring.mapper")
public class ThinkingInSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThinkingInSpringApplication.class, args);
    }
}
