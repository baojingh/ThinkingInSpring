package com.bd.thinkinginspring.controller;

import com.bd.thinkinginspring.entity.Stu;
import com.bd.thinkinginspring.service.impl.StuServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: baojing.he
 * @Date: 2021/1/4 21:59
 * @Description:
 */
@RestController
public class StuController {
    private static Logger LOGGER = LoggerFactory.getLogger(StuController.class);

    @Autowired
    private StuServiceImpl stuService;


    @RequestMapping(value = "getStus/", method = RequestMethod.GET)
    public List<Stu> getStus() {
        LOGGER.info("hello world 何保敬");
        return stuService.getAllStu();
    }

    @RequestMapping(value = "add/")
    public void addStu() {
        Stu stu = Stu.builder().id(3).addr("nanjing").age(22).dept_id(4).build();
        stuService.insert(stu);
    }

}
