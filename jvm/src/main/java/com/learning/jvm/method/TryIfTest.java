package com.learning.jvm.method;

/**
 * @author : linghan.ma
 * @Package com.learning.jvm.method
 * @Description:
 * @date Date : 2019年07月26日 3:21 PM
 **/
public class TryIfTest {
    // 编译并用 javap -c 查看编译后的字节码
    private int tryBlock;
    private int catchBlock;
    private int finallyBlock;
    private int methodExit;

    public void test() {
        for (int i = 0; i < 100; i++) {
            try {
                tryBlock = 0;
                if (i < 50) {
                    continue;
                } else if (i < 80) {
                    break;
                } else {
                    return;
                }
            }catch (RuntimeException e){
                catchBlock = 1;
            }catch (Exception e) {
                catchBlock = 1;
            } finally {
                finallyBlock = 2;
            }
        }
        methodExit = 3;
    }
/**
 Compiled from "TryIfTest.java"
 public class com.learning.jvm.method.TryIfTest {
 public com.learning.jvm.method.TryIfTest();
 Code:
 0: aload_0
 1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 4: return

 public void test();
 Code:
 0: iconst_0
 1: istore_1
 2: iload_1
 3: bipush        100
 5: if_icmpge     89
 8: aload_0
 9: iconst_0
 10: putfield      #2                  // Field tryBlock:I
 13: iload_1
 14: bipush        50
 16: if_icmpge     27
 19: aload_0
 20: iconst_2
 21: putfield      #3                  // Field finallyBlock:I



 24: goto          83
 27: iload_1
 28: bipush        80
 30: if_icmpge     41
 33: aload_0
 34: iconst_2
 35: putfield      #3                  // Field finallyBlock:I


 38: goto          89
 41: aload_0
 42: iconst_2
 43: putfield      #3                  // Field finallyBlock:I
 46: return
 47: astore_2
 48: aload_0
 49: iconst_1
 50: putfield      #5                  // Field catchBlock:I
 53: aload_0
 54: iconst_2
 55: putfield      #3                  // Field finallyBlock:I


 58: goto          83
 61: astore_2
 62: aload_0
 63: iconst_1
 64: putfield      #5                  // Field catchBlock:I
 67: aload_0
 68: iconst_2
 69: putfield      #3                  // Field finallyBlock:I


 72: goto          83
 75: astore_3
 76: aload_0
 77: iconst_2
 78: putfield      #3                  // Field finallyBlock:I
 81: aload_3
 82: athrow
 83: iinc          1, 1


 86: goto          2
 89: aload_0
 90: iconst_3
 91: putfield      #7                  // Field methodExit:I
 94: return
 Exception table:
 from    to  target type
 8    19    47   Class java/lang/RuntimeException
 27    33    47   Class java/lang/RuntimeException
 8    19    61   Class java/lang/Exception
 27    33    61   Class java/lang/Exception
 8    19    75   any
 27    33    75   any
 47    53    75   any
 61    67    75   any
 }

 */
}
