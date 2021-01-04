package com.bd.thinkinginspring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 * @Author: baojing.he
 * @Date: 2021/1/4 21:51
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("stu")
public class Stu {
    @PrimaryKey
    private int id;
    private int age;
    private String name;
    private String addr;
    private int dept_id;
}
