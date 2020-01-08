package com.learning.jvm.method;

/**
 * @author : linghan.ma
 * @Package com.learning.jvm.method
 * @Description:
 * @date Date : 2019年07月26日 2:34 AM
 **/
/**
 * 方法静态分派演示
 * @author zzm
 */
public class StaticDispatch {

    /**
     * super
     */
    static abstract class Human {
    }

    /**
     * child1
     */
    static class Man extends Human {
    }

    /**
     * child2
     */
    static class Woman extends Human {
    }

    public void sayHello(Human guy) {
        System.out.println("hello,guy!");
    }

    /**
     * overload
     * @param guy
     */
    public void sayHello(Man guy) {
        System.out.println("hello,gentleman!");
    }

    /**
     * overload
     * @param guy
     */
    public void sayHello(Woman guy) {
        System.out.println("hello,lady!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sr = new StaticDispatch();
        sr.sayHello(man);
        sr.sayHello(woman);
        sr.sayHello((Man)man);
        sr.sayHello((Woman)woman);
    }
}