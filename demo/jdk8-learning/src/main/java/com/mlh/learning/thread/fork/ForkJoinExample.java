package com.mlh.learning.thread.fork;

import java.util.concurrent.ForkJoinPool;

/**
 * @author : linghan.ma
 * @Package com.mlh.learning.thread.fork
 * @Description:
 * @date Date : 2019年05月21日 5:42 PM
 **/
public class ForkJoinExample {
    public static void main(String[] args) {
//        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
//        ForkJoinPool forkJoinPool = new ForkJoinPool();
//        int[] arr = new int[]{1,2,3,4};
//        CustomRecursiveTask customRecursiveTask  = new CustomRecursiveTask(arr);
//
//        forkJoinPool.execute(customRecursiveTask);
//       int result =  customRecursiveTask.join();

//        int result = forkJoinPool.invoke(customRecursiveTask);
//        System.out.println(result);

        MyRecursiveTask myRecursiveTask = new MyRecursiveTask(128);

        ForkJoinPool forkJoinPool = new ForkJoinPool(4);

        long mergedResult = forkJoinPool.invoke(myRecursiveTask);

        System.out.println("mergedResult = " + mergedResult);

    }
}
