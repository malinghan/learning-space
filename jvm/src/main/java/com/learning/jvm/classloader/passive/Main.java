package com.learning.jvm.classloader.passive;

/**
 * @author : linghan.ma
 * @Package com.learning.jvm.classloader.passive
 * @Description:
 * @date Date : 2019年08月13日 2:26 PM
 **/
public class Main {
    public static void main(String[] args) {
        //子类没有初始化？？
        System.out.println(SubClass.value);
    }
}
