package com.bd.thinkinginspring.test;

import java.lang.annotation.*;

/**
 * @Author: baojing.he
 * @Date: 2021-02-28 12:18
 * @Description:
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    String value() default "";
}
