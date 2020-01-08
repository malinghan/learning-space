package com.learning.jvm.classloader.passive;

/**
 * @author : linghan.ma
 * @Package com.learning.jvm.classloader.passive
 * @Description:
 * @date Date : 2019年08月13日 4:15 PM
 **/
public class Main4 {
     //构造器或静态代码块中死循环，无线init
    static class DeadLoopClass {
        static {
            // 如果不加上这个if语句，编译器将提示“Initializer does not complete normally”并拒绝编译
            if (true) {
                System.out.println(Thread.currentThread() + "init DeadLoopClass");
                while (true) {
                    System.out.println(Thread.currentThread() + "init DeadLoopClass");
                }
            }
        }
    }

    public static void main(String[] args) {
        Runnable script = new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread() + "start");
                DeadLoopClass dlc = new DeadLoopClass();
                System.out.println(Thread.currentThread() + " run over");
            }
        };

        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);
        thread1.start();
        thread2.start();
    }
}
