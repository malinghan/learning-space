package com.example.demo.test1;

public class DogBarkFactory {

    private static  volatile DogBarkFactory dogBarkFactory;

    private static  volatile DogBark dogBark;

    private DogBarkFactory(){}

    public static DogBarkFactory getFactory(){
        if(dogBarkFactory == null) {
            synchronized (DogBarkFactory.class) {
                if (dogBarkFactory == null) {
                    dogBarkFactory = new DogBarkFactory();
                }
            }
        }
        return dogBarkFactory;
    }



    public DogBark getDogBark(String companyId){
        System.out.println(companyId == CommonHelper.getThreadLocalString());
        if(dogBark == null) {
            synchronized (DogBarkFactory.class) {
             if(dogBark == null){
                 dogBark = new DogBark();
             }
            }
        }
        dogBark.setCompanyId(companyId);
        return dogBark;
    }
}
