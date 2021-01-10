package com.bd.thinkinginspring.service;

import java.io.Serializable;

/**
 * @Author: baojing.he
 * @Date: 2021/1/10 16:45
 * @Description:
 */
public interface AuthenticationToken extends Serializable {
    Object getPrincipal();
    Object getCredentials();
}
