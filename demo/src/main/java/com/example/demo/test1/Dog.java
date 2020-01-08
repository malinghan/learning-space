package com.example.demo.test1;

import java.util.concurrent.CountDownLatch;

public class Dog implements Runnable {
    private CountDownLatch countDownLatch;
    private DogBarkFactory dogBarkFactory;
    private int cnt;

    public Dog(CountDownLatch countDownLatch,DogBarkFactory dogBarkFactory,String companyId,int cnt){
        this.countDownLatch = countDownLatch ;
        this.cnt = cnt;
        this.dogBarkFactory = dogBarkFactory;
        CommonHelper.setThreadLocalString(companyId);
//        System.out.println("new:"+CommonHelper.getThreadLocalString());
    }


    @Override
    public void run() {
           dogBarkFactory.getDogBark(CommonHelper.getThreadLocalString()).getCount(cnt);
             try {
                 countDownLatch.await();
             }catch (Exception e){
                 System.out.println("error");
             }
             //看看是不是同时运行
//             System.out.println(Thread.currentThread().getName()+" "+System.currentTimeMillis());

    }
}
