package com.bd.thinkinginspring.entity;

import lombok.*;

/**
 * @Author: hebj
 * @Date: 2021/1/2 19:05
 * @Description:
 */


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int     id;
    private String  name;
    private int     age;
    private String  addr;
    private int     deptId;
}
