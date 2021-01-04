package com.bd.thinkinginspring.service.impl;

import com.bd.thinkinginspring.entity.Stu;
import com.bd.thinkinginspring.mapper.StuDao;
import com.bd.thinkinginspring.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: baojing.he
 * @Date: 2021/1/4 21:57
 * @Description:
 */


@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StuDao stuDao;

    @Override
    public List<Stu> getAllStu() {
        return stuDao.getStuAll();
    }

    @Override
    public void insert(Stu stu) {
        stuDao.insert(stu);
    }
}
