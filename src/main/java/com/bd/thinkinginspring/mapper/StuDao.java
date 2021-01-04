package com.bd.thinkinginspring.mapper;

import com.bd.thinkinginspring.entity.Stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: baojing.he
 * @Date: 2021/1/4 21:53
 * @Description:
 */
@Repository
public class StuDao {

    @Autowired
    private CassandraTemplate cassandraTemplate;

    public List<Stu> getStuAll() {
        List<Stu> stuList = cassandraTemplate.select("select * from stu", Stu.class);
        return stuList;
    }

    public void insert(Stu stu) {
        cassandraTemplate.insert(stu);
    }


}
