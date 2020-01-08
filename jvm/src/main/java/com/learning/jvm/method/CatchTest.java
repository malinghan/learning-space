package com.learning.jvm.method;

/**
 * @author : linghan.ma
 * @Package com.learning.jvm.method
 * @Description:
 * @date Date : 2019年07月26日 2:41 PM
 **/
public class CatchTest {
    private int tryBlock;
    private int catchBlock;
    private int finallyBlock;
    private int methodExit;

    public void test() {
        try {
            tryBlock = 0;
        } catch (Exception e) {
            catchBlock = 1;
        } finally {
            finallyBlock = 2;
        }
        methodExit = 3;
    }
}

/**
 *   Compiled from "CatchTest.java"
 *   public class com.learning.jvm.method.CatchTest {
 *   public com.learning.jvm.method.CatchTest();
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V -> CatchTest
 *        4: return
 *
 *   public void test();
 *     Code:
 *        0: aload_0
 *        1: iconst_0
 *        2: putfield      #2                  // Field tryBlock:I
 *        5: aload_0
 *        6: iconst_2
 *        7: putfield      #3                  // Field finallyBlock:I  0 -> 2
 *       10: goto          35
 *       13: astore_1
 *       14: aload_0
 *       15: iconst_1
 *       16: putfield      #5                  // Field catchBlock:I
 *       19: aload_0
 *       20: iconst_2
 *       21: putfield      #3                  // Field finallyBlock:I  1 -> 2
 *       24: goto          35
 *       27: astore_2
 *       28: aload_0
 *       29: iconst_2
 *       30: putfield      #3                  // Field finallyBlock:I 2 -> 2
 *       33: aload_2
 *       34: athrow
 *       35: aload_0
 *       36: iconst_3
 *       37: putfield      #6                  // Field methodExit:I -> 3
 *       40: return
 *     Exception table:
 *        from    to  target type
 *            0     5    13   Class java/lang/Exception
 *            0     5    27   any
 *           13    19    27   any
 * }
 */