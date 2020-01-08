package com.learning.jvm.compile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : linghan.ma
 * @Package com.learning.jvm.compile
 * @Description:
 * @date Date : 2019年08月27日 4:38 PM
 **/
public class ParamterExample {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("hello", "你好");
        map.put("how are you?", "吃了没？");
        System.out.println(map.get("hello"));
        System.out.println(map.get("how are you?"));
    }
}
