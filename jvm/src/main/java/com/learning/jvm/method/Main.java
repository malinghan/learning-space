package com.learning.jvm.method;

/**
 * @author : linghan.ma
 * @Package com.learning.jvm.method
 * @Description:
 * @date Date : 2019年07月26日 2:10 AM
 **/
public class Main {
    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        System.gc();
    }
}
