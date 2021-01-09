package com.bd.thinkinginspring.entity;

import lombok.*;

/**
 * @Author: baojing.he
 * @Date: 2021/1/9 21:42
 * @Description:
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleInfoEntity {
    private int id;
    private String roleName;
}
