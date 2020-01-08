package com.mlh.learning.completableFuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 1. 多个Future依赖时无法感知
 * 2. 多个Future计算合并
 * 3. Future集合中的所有都完成时
 * 4. Future完成事件
 */
public class FutureTest {
    public void executor(){
        ExecutorService service = Executors.newSingleThreadExecutor();

        Future<Integer> future = service.submit(() -> {
            try {
                Thread.sleep(5000);
            }catch (Exception e){
                e.printStackTrace();
            }
            return 1;
        });
        try {
            System.out.println(future.get());
            System.out.println("finish!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
