package com.learning.jvm.classloader.passive;

/**
 * @author : linghan.ma
 * @Package com.learning.jvm.classloader.passive
 * @Description:
 * @date Date : 2019年08月13日 4:14 PM
 **/
public class Test {
    static {
        i = 0;  //  给变量复制可以正常编译通过
//        System.out.print(i);  // 这句编译器会提示“非法向前引用”
    }
    static int i = 1;
}