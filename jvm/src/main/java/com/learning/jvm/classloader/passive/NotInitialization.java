package com.learning.jvm.classloader.passive;

/**
 * @author : linghan.ma
 * @Package com.learning.jvm.classloader.passive
 * @Description:
 * @date Date : 2019年08月13日 2:42 PM
 **/
public class NotInitialization {
    public static void main(String[] args) {
        //通过数组定义来引用类,不会触发此类的初始化
        SuperClass [] sca = new SuperClass[10];
    }
}
