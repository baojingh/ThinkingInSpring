package com.bd.thinkinginspring.test;

/**
 * @Author: baojing.he
 * @Date: 2021-02-28 12:32
 * @Description:
 */


public class Student {
    private int id;
    private String name;


    @Log("helloworld test")
    public String getName() {
        return "helloworld";
    }

    public int getAge() {
        return 11;
    }


}
