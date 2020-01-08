package com.learning.jvm.op;

/**
 * @author : linghan.ma
 * @Package com.learning.jvm.gc
 * @Description:
 * @date Date : 2019年07月17日 11:41 AM
 **/
public class PretenureSizeThresholdTest {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];  //直接分配在老年代中
    }

    public static void main(String[] args) {
        PretenureSizeThresholdTest.testPretenureSizeThreshold();
    }
}
