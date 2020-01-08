package com.learning.jvm.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : linghan.ma
 * @Package com.learning.jvm.memory
 * @Description: 测试堆溢出
 * @date Date : 2019年07月15日 6:52 PM
 **/
public class HeapOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
