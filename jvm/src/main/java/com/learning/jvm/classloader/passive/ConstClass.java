package com.learning.jvm.classloader.passive;

/**
 * @author : linghan.ma
 * @Package com.learning.jvm.classloader.passive
 * @Description:
 * @date Date : 2019年08月13日 2:52 PM
 **/
public class ConstClass {
    static {
        System.out.println("ConstClass init !");
    }
    public static final  String HELLOWORLD =  "hello world";
}
