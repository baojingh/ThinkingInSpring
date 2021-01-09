package com.bd.thinkinginspring.entity;

import lombok.*;

/**
 * @Author: baojing.he
 * @Date: 2021/1/9 21:40
 * @Description:
 */


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleEntity {
    private int id;
    private int userId;
    private int roleId;
}
