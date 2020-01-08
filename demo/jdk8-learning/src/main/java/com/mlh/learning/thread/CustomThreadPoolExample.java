package com.mlh.learning.thread;

/**
 * @author : linghan.ma
 * @Package com.mlh.learning.thread
 * @Description:
 * @date Date : 2019年05月21日 4:34 PM
 **/
public class CustomThreadPoolExample {
    public static void main(String[] args) {
        CustomThreadPool customThreadPool = new CustomThreadPool(2);

        for (int i = 1; i <= 5; i++) {
            Task task = new Task("Task " + i);
            System.out.println("Created : " + task.getName());

            customThreadPool.execute(task);
        }
    }
}