package com.learning.jvm.vola;

/**
 * @author : linghan.ma
 * @Package com.learning.jvm.vola
 * @Description:
 * @date Date : 2019年08月28日 10:03 PM
 **/
public class VolatileTest {
    public static volatile int race=0;

    public  static void increase(){
        race++;
    }

    private static final  int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        increase();
                    }
                }
            });
        }
    }
}
