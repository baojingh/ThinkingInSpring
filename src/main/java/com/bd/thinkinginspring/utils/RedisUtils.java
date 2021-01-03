package com.bd.thinkinginspring.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author: baojing.he
 * @Date: 2021/1/3 11:43
 * @Description:
 */

@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * get value with key
     * @param key
     * @return
     */
    public Object get(String key) {
        if (key == null) {
            return new Object();
        } else {
            Object o = redisTemplate.opsForValue().get(key);
            return o;
        }
    }

    public boolean set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
        return true;
    }




}
