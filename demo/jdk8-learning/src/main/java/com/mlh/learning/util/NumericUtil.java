package com.mlh.learning.util;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wangbo on 16/9/4.
 */
public class NumericUtil {

    /**
     * 生成指定长度的随机数
     *
     * @param length
     * @return
     */
    public static int generateRandomNumber(int length) {
        return (int) ((Math.random() * 9 + 1) * pow(10, length - 1));
    }

    /**
     * 求a的b次方
     *
     * @param a
     * @param b
     * @return
     */
    public static int pow(int a, int b) {
        int result = 1;
        for (int i = 0; i < b; i++)
            result *= a;
        return result;
    }

    public static int findMin(int n1, int n2) {
        return n1 < n2 ? n1 : n2;
    }

    public static int findMax(int n1, int n2) {
        return n1 > n2 ? n1 : n2;
    }

    public static double findMin(double n1, double n2) {
        return n1 < n2 ? n1 : n2;
    }

    public static double findMax(double n1, double n2) {
        return n1 > n2 ? n1 : n2;
    }

    /**
     * 返回两位小数
     *
     * @param number
     * @return
     */
    public static double keep2(double number) {
        return keepN(number, 2);
    }

    /**
     * 返回四位小数
     * @param number
     * @return
     */
    public static double keep4(double number) {
        return keepN(number, 4);
    }

    /**
     * 保留n位小数
     * @param number
     * @param scale
     * @return
     */
    public static double keepN(double number, int scale) {
        BigDecimal temp = new BigDecimal(number, MathContext.DECIMAL64);
        return temp.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 输出百分数形式: "23.2%"
     * @param number
     * @param fractionDigits 小数位数
     * @return
     */
    public static String formatPercent(double number, int fractionDigits) {
        NumberFormat defaultFormat = NumberFormat.getPercentInstance();
        defaultFormat.setRoundingMode(RoundingMode.HALF_UP);
        defaultFormat.setMinimumFractionDigits(fractionDigits);
        return defaultFormat.format(number);
    }

    /**
     * 字符串转整数，类似PHP里的intval
     * 注意！非数字会返回 0
     * @author fanglijun
     * @param str
     * @return
     */
    public static int parseInt(String str) {
        String regex = "^-?\\d+";
        Pattern regPattern = Pattern.compile(regex);
        Matcher matcher = regPattern.matcher(str);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        } else {
            return 0;
        }
    }

    /**
     * 字符串转Double，类似PHP里的floatval
     * 注意！非数字会返回0.0
     * @author fanglijun
     * @param str
     * @return
     */
    public static double parseDouble(String str) {
        if (null == str) {
            return 0.0;
        }
        String regex = "^-?\\d*\\.?\\d*";
        Pattern regPattern = Pattern.compile(regex);
        Matcher matcher = regPattern.matcher(str);
        if (matcher.find() && !"".equals(matcher.group()) && !"-".equals(matcher.group())) {
            return Double.parseDouble(matcher.group());
        } else {
            return 0.0;
        }
    }

    /**
     * 计算Map里数字的和
     * 要求Map的值是Number；如果map为null或空，返回 0.0
     * @param map
     * @param <T>
     * @return
     */
    public static <T extends Number> Double sumMap(Map<?, T> map) {
        if (null == map) {
            return 0.0;
        }

        Double sum = 0.0;
        for (Map.Entry<?, T> entry : map.entrySet()) {
            sum += entry.getValue().doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        // testParseDouble();
        testSumMap();
    }

    /**
     * 测试 parseDouble
     */
    public static void testParseDouble() {
        String[] strings = new String[] {
                "1.9abc",
                "0.9abc",
                ".9abc",
                "9abc",
                "abc",
                "abc9",
        };

        for (int i=0; i<strings.length; ++i) {
            System.out.println(strings[i] + " => " + parseDouble(strings[i]));
            System.out.println("-" + strings[i] + " => " + parseDouble("-" + strings[i]));
        }
    }

    /**
     * 测试 sumMap
     */
    public static void testSumMap() {
        Map<String, Integer> integerMap = new HashMap<>();
        Integer trueSum = 0;
        for (int i = 0; i<5; ++i) {
            Integer num = RandomUtils.nextInt(99999);
            trueSum += num;
            integerMap.put(RandomStringUtils.random(5), num);
        }
        System.out.println("trueSum: " + trueSum);
        Double sum = sumMap(integerMap);
        System.out.println("sumMap: " + sum.intValue());

        Map<String, Double> doubleMap = new HashMap<>();
        Double trueSumDouble = 0.0;
        for (int i = 0; i<5; ++i) {
            Double num = RandomUtils.nextDouble();
            trueSumDouble += num;
            doubleMap.put(RandomStringUtils.random(5), num);
        }
        System.out.println("trueSumDouble: " + trueSumDouble);
        Double sumDouble = sumMap(doubleMap);
        System.out.println("sumMapDouble: " + sumDouble);
    }
}
