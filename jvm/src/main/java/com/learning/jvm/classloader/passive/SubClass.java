package com.learning.jvm.classloader.passive;

/**
 * @author : linghan.ma
 * @Package com.learning.jvm.classloader.passive
 * @Description:
 * @date Date : 2019年08月13日 2:24 PM
 **/
public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
}
