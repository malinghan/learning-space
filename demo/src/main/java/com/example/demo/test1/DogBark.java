package com.example.demo.test1;

public class DogBark {
    protected  int count = 0;
    protected String companyId;

    public void getCount(int cnt){
        this.count = cnt;
//        try {
//            Thread.sleep(100);
//        }catch (Exception we){
//            System.out.println("error");
//        }
//        for (int i = 0; i < 100; i++) {
//            count ++;
//        }
       System.out.println(Thread.currentThread()+"cnt:"+cnt+" count:"+count+"result:"+(count-cnt));
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
