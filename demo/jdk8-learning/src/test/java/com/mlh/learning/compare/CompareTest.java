package com.mlh.learning.compare;

import com.mlh.learning.completableFuture.FutureTest;
import com.mlh.learning.util.NumUtils;
import com.mlh.learning.util.NumberUtil;

import java.util.*;
import java.util.stream.Collectors;

public class CompareTest {

    @org.junit.Test
    public void testFuture(){
        List<String> strings1 = Arrays.asList("1","2","3","4","5");
        List<String> sdas = strings1.stream().sorted(Comparator.comparing(s-> Integer.valueOf(s),(o1,o2) -> (o2 - o1))).collect(Collectors.toList());
        System.out.println(sdas);
     }

    @org.junit.Test
    public void testChinese2(){
        System.out.println( NumUtils.toChineseLower(12));
    }

    @org.junit.Test
    public void testChinese3(){
        System.out.println(NumberUtil.getChineseIntStr(12));
    }

    @org.junit.Test
    public void testChinese6(){
        System.out.println( toChinese6(1));
        System.out.println( toChinese6(2));
        System.out.println( toChinese6(99));
        System.out.println( toChinese6(10));
        System.out.println( toChinese6(11));
        System.out.println( toChinese6(12));
        System.out.println( toChinese6(22));
        System.out.println( toChinese6(32));
        System.out.println( toChinese6(42));
        System.out.println( toChinese6(52));
        System.out.println( toChinese6(62));
        System.out.println( toChinese6(72));
        System.out.println( toChinese6(82));
        System.out.println( toChinese6(1212122));
        System.out.println( toChinese6(-1212));
        System.out.println( toChinese6(-12109092));
    }

    @org.junit.Test
    public void testChinese(){
//        System.out.println( toChinese(0));
//        System.out.println( toChinese(100));
        System.out.println( toChinese(1));
        System.out.println( toChinese(2));
        System.out.println( toChinese(99));
        System.out.println( toChinese(10));
        System.out.println( toChinese(11));
        System.out.println( toChinese(12));
        System.out.println( toChinese(22));
        System.out.println( toChinese(32));
        System.out.println( toChinese(42));
        System.out.println( toChinese(52));
        System.out.println( toChinese(62));
        System.out.println( toChinese(72));
        System.out.println( toChinese(82));
    }


    public static String toChinese6(int count) {
        if (count == 1) {
            return "首次";
        }
        String result = NumberUtil.getChineseIntStr(count);
        return result+"次";
    }


    public static String toChinese(int count) {
        if (count < 1 || count > 99) {
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
                if(n == 2 && s.charAt(0) - '0' == 1){
                    result.append(s2);
                }else {
                    result.append(s1[num]).append(s2);
                }
            } else if (num != 0) {
                result.append(s1[num]);
            }
        }
        result.append("次");
        return result.toString();
    }
}

