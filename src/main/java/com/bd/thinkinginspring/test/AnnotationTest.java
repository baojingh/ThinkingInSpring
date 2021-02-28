package com.bd.thinkinginspring.test;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * @Author: baojing.he
 * @Date: 2021-02-28 12:18
 * @Description:
 */


@Slf4j
public class AnnotationTest {

    public static void main(String[] args) throws ClassNotFoundException {
        Method[] declaredMethods = Student.class.getDeclaredMethods();
        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(Log.class)) {
                Log annotation = method.getAnnotation(Log.class);
                log.info(annotation.value());
            } else {
                String name = method.getName();
//                log.info(name);
            }


        }

    }

}
