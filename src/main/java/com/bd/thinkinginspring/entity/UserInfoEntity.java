package com.bd.thinkinginspring.entity;

import lombok.*;

/**
 * @Author: baojing.he
 * @Date: 2021/1/9 21:39
 * @Description:
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserInfoEntity {
    private int id;
    private String userName;
    private String password;
}
