package com.learning.jvm.instant;



import java.time.Instant;

/**
 * @author : linghan.ma
 * @Package com.learning.jvm.instant
 * @Description:
 * @date Date : 2019年07月19日 12:46 PM
 **/
public class InstantTest {
    public static void main(String[] args) {
        System.out.println(Instant.now().getEpochSecond());
    }
}
