package com.bd.thinkinginspring.entity;

import lombok.*;

/**
 * @Author: baojing.he
 * @Date: 2021/1/9 21:41
 * @Description:
 */


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PermissionRoleEntity {
    private int id;
    private String permissionName;
    private int roleId;
}
