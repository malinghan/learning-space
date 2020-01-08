package com.example.demo;

import com.example.demo.test1.Dog;
import com.example.demo.test1.DogBark;
import com.example.demo.test1.DogBarkFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }


    @Test
    public void test() {
        System.out.println(toChinese(97));
    }

    @Test
    public void testAAA() {
        Map<String, List<ERecruitHeaderField>> s = ERecruitHeaderField.getERecruitHeaderFieldMapByFormId(30);
        System.out.println(s);
    }

    protected static String toChinese(int count) {
        if (count <= 0 || count > 100) {
            return "";
        }
        if (count == 1) {
            return "首次";
        }
        String s = String.valueOf(count);
        String[] s1 = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        String s2 = "十";
        StringBuilder result = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int num = s.charAt(i) - '0';
            if (i != n - 1 && num != 0) {
                result.append(s1[num]).append(s2);
            } else if (num != 0) {
                result.append(s1[num]);
            }
        }
        result.append("次");
        return result.toString();
    }

    @Test
    public void test2121() {
        List<Apple> aaa = new ArrayList<>();
        aaa.add(new Apple("a1", "b1"));
        aaa.add(new Apple("a1", "b2"));
        aaa.add(new Apple("a2", "b3"));
        aaa.add(new Apple("a2", "b4"));
        aaa.add(new Apple("a2", "b5"));
        aaa.add(new Apple("a3", "b6"));
        aaa.add(new Apple("a3", "b7"));
        aaa.add(new Apple("a4", "b8"));
        aaa.add(new Apple("a4", "b9"));
        aaa.add(new Apple("a4", "b10"));
        aaa.add(new Apple("a4", "b11"));
        aaa.add(new Apple("a4", "b12"));
        aaa.add(new Apple("a4", "b13"));
        aaa.add(new Apple("a5", "b14"));
        aaa.add(new Apple("a6", "b15"));
        aaa.add(new Apple("a8", "b16"));
        aaa.add(new Apple("a9", "b17"));
        aaa.add(new Apple("a9", "b18"));
        Integer cnt = 0;
        if (!CollectionUtils.isEmpty(aaa)) {
            Long a = aaa.stream().collect(Collectors.groupingBy(Apple::getK,
                    Collectors.counting())).values().stream().reduce(Long::max).orElse(0L);
            Map<String, Long> finalMap = new HashMap<>();
            System.out.println(a);
        }
    }

    @Test
    public void testDogBark(){
        final int N = 10;
        CountDownLatch countDownLatch = new CountDownLatch(N);
        DogBarkFactory dogBarkFactory = DogBarkFactory.getFactory();
        for(int i=0;i<N;i++){
            new Thread(new Dog(countDownLatch,dogBarkFactory,"companyId"+i,i*2000)).start();
            countDownLatch.countDown();
        }
    }

    @Test
    public void testGroupByNull() {
        List<Apple> aaa = new ArrayList<>();
        aaa.add(new Apple("a1", "b1"));
        aaa.add(new Apple("a1", "b2"));
        aaa.add(new Apple("a2", "b3"));
        aaa.add(new Apple("a2", "b4"));
        aaa.add(new Apple("a2", "b5"));
        aaa.add(new Apple("a3", "b6"));
        aaa.add(new Apple("a3", "b7"));
        aaa.add(new Apple(null, "b8"));
        aaa.add(new Apple(null, "b9"));
        aaa.add(new Apple(null, "b10"));
        aaa.add(new Apple(null, "b11"));
        aaa.add(new Apple(null, "b12"));
        aaa.add(new Apple(null, "b13"));
        aaa.add(new Apple("a5", "b14"));
        aaa.add(new Apple("a6", "b15"));
        aaa.add(new Apple("a8", "b16"));
        aaa.add(new Apple("a9", "b17"));
        aaa.add(new Apple("a9", "b18"));
        Integer cnt = 0;
        if (!CollectionUtils.isEmpty(aaa)) {
            Map<String, Long> aMap = aaa.stream()
                    .filter(s -> s.getK() != null)
                    .collect(Collectors.groupingBy(
                            Apple::getK,
                            Collectors.counting()));
            System.out.println(aMap);
        }

        if (!CollectionUtils.isEmpty(aaa)) {
            Map<String, Long> bMap = aaa.stream()
                    .peek(s -> {
                        if (s.getK() == null) {
                            s.setK("a4");
                        }
                    }).collect(Collectors.groupingBy(
                            Apple::getK,
                            Collectors.counting()));
            System.out.println(bMap);
        }
    }


    class Apple {
        private String k;
        private String v;

        public Apple(String k, String v) {
            this.k = k;
            this.v = v;
        }

        public String getK() {
            return k;
        }

        public void setK(String k) {
            this.k = k;
        }

        public String getV() {
            return v;
        }

        public void setV(String v) {
            this.v = v;
        }
    }

}

