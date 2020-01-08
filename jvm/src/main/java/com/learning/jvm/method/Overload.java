package com.learning.jvm.method;

import java.io.Serializable;

/**
 * @author : linghan.ma
 * @Package com.learning.jvm.method
 * @Description:  静态分派的重载的优先级问题
 *   解析期完成
 *  - object
 *  - int
 *  - long
 *  - character
 *  - char
 *  - char ... 可变参数
 *  - Serializable
 *  - String[]
 * @date Date : 2019年07月26日 2:39 AM
 **/
public class Overload {

    public static void sayHello(Object arg) {
        System.out.println("hello Object");
    }

    public static void sayHello(int arg) {
        System.out.println("hello int");
    }

    public static void sayHello(long arg) {
        System.out.println("hello long");
    }

    public static void sayHello(Character arg) {
        System.out.println("hello Character");
    }

    public static void sayHello(char arg) {
        System.out.println("hello char");
    }

    public static void sayHello(char... arg) {
        System.out.println("hello char ...");
    }

    public static void sayHello(Serializable arg) {
        System.out.println("hello Serializable");
    }

    public static void main(String[] args) {
        sayHello('a');
        sayHello(1L);
        sayHello();
//        sayHello(null);
    }
}
