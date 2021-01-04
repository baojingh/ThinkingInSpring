package com.bd.thinkinginspring.service;

import com.bd.thinkinginspring.entity.Stu;

import java.util.List;

/**
 * @Author: baojing.he
 * @Date: 2021/1/4 21:56
 * @Description:
 */
public interface StuService {
    List<Stu> getAllStu();
    void insert(Stu stu);
}
