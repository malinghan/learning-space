package com.learning.jvm.reference;

/**
 * @author : linghan.ma
 * @Package com.learning.jvm.reference
 * @Description:
 * @date Date : 2019年07月16日 5:38 PM
 **/
public class GCTarget {
    // 对象的ID
    public String id;

    // 占用内存空间
    byte[] buffer = new byte[1024];

    public GCTarget(String id) {
        this.id = id;
    }

    protected void finalize() throws Throwable {
        // 执行垃圾回收时打印显示对象ID
        System.out.println("Finalizing GCTarget, id is : " + id);
    }
}