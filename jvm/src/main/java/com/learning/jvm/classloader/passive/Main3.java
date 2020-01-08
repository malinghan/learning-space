package com.learning.jvm.classloader.passive;

/**
 * @author : linghan.ma
 * @Package com.learning.jvm.classloader.passive
 * @Description:
 * @date Date : 2019年08月13日 4:14 PM
 **/
public class Main3 {
    static class Parent {
        public static int A = 1;
        //static对static变量赋值
        static {
            A = 2;
        }
    }

    static class Sub extends Parent {
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B);
    }
}
