package com.mlh.learning.thread.reentrant;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author : linghan.ma
 * @Package com.mlh.learning.thread.reentrant
 * @Description:
 * @date Date : 2019年05月23日 6:16 PM
 **/
public class ReentrantLock {

    private AtomicReference<Thread> owner = new AtomicReference<Thread>();
    private int state = 0;

    public void lock() {
        System.out.println(Thread.currentThread().getName());
        Thread current = Thread.currentThread();
        if (current == owner.get()) {
            state++;
            return;
        }
        //这句是很经典的“自旋”式语法，AtomicInteger中也有
        for (;;) {
            if (!owner.compareAndSet(null, current)) {
                return;
            }
        }
    }

    public void unlock() {
        System.out.println(Thread.currentThread().getName());
        Thread current = Thread.currentThread();
        if (current == owner.get()) {
            if (state != 0) {
                state--;
            } else {
                owner.compareAndSet(current, null);
            }
        }
    }

    public static void main(String[] args) {
        UnreentrantLock rt = new UnreentrantLock();
        for(;;){
            rt.lock();
        }
    }
}
