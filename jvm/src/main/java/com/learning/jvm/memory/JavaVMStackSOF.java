package com.learning.jvm.memory;

/**
 * @author : linghan.ma
 * @Package com.learning.jvm.memory
 * @Description:
 * @date Date : 2019年07月15日 7:27 PM
 **/
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
