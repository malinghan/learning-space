package com.learning.jvm.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * @author : linghan.ma
 * @Package com.learning.jvm.memory
 * @Description:
 * @date Date : 2019年07月16日 5:30 PM
 **/
public class SoftReferenceTest {
    public static void main(String[] args) {
        ReferenceQueue<String> referenceQueue = new ReferenceQueue();
        String str = new String("abc");
        SoftReference<String> softReference = new SoftReference(str, referenceQueue);

        str = null;
        // Notify GC
        System.gc();

        System.out.println(softReference.get()); // abc

        Reference<? extends String> reference = referenceQueue.poll();
        System.out.println(reference); //null

    }
}
