package com.learning.jvm.method;

/**
 * @author : linghan.ma
 * @Package com.learning.jvm.method
 * @Description:
 * Suppressed -> 允许开发人员将一个异常附于另一个异常之上。因此，抛出的异常可以附带多个异常信息
 * @date Date : 2019年07月26日 2:52 PM
 **/
public class TryWithResourcesOptTest implements AutoCloseable  {
        private final String name;

        public TryWithResourcesOptTest(String name) {
            this.name = name;
        }

        @Override
        public void close() {
            throw new RuntimeException(name);
        }

        public static void main(String[] args) {
            try (TryWithResourcesOptTest foo0 = new TryWithResourcesOptTest("Foo0"); // try-with-resources
                 TryWithResourcesOptTest foo1 = new TryWithResourcesOptTest("Foo1");
                 TryWithResourcesOptTest foo2 = new TryWithResourcesOptTest("Foo2")){
                throw new RuntimeException("Initial");
            }
        }
    }

    /**
    // 运行结果：
    Exception in thread "main" java.lang.RuntimeException: Initial
    at Foo.main(Foo.java:18)
    Suppressed: java.lang.RuntimeException: Foo2
    at Foo.close(Foo.java:13)
    at Foo.main(Foo.java:19)
    Suppressed: java.lang.RuntimeException: Foo1
    at Foo.close(Foo.java:13)
    at Foo.main(Foo.java:19)
    Suppressed: java.lang.RuntimeException: Foo0
    at Foo.close(Foo.java:13)
    at Foo.main(Foo.java:19)
     **/

/**
 * Compiled from "TryWithResourcesOptTest.java"
 * public class com.learning.jvm.method.TryWithResourcesOptTest implements java.lang.AutoCloseable {
 *   public com.learning.jvm.method.TryWithResourcesOptTest(java.lang.String);
 *     Code:
 *        0: aload_0
 *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *        4: aload_0
 *        5: aload_1
 *        6: putfield      #2                  // Field name:Ljava/lang/String;
 *        9: return
 *
 *   public void close();
 *     Code:
 *        0: new           #3                  // class java/lang/RuntimeException
 *        3: dup
 *        4: aload_0
 *        5: getfield      #2                  // Field name:Ljava/lang/String;
 *        8: invokespecial #4                  // Method java/lang/RuntimeException."<init>":(Ljava/lang/String;)V
 *       11: athrow
 *
 *   public static void main(java.lang.String[]);
 *     Code:
 *        0: new           #5                  // class com/learning/jvm/method/TryWithResourcesOptTest
 *        3: dup
 *        4: ldc           #6                  // String Foo0
 *        6: invokespecial #7                  // Method "<init>":(Ljava/lang/String;)V
 *        9: astore_1
 *       10: aconst_null
 *       11: astore_2
 *       12: new           #5                  // class com/learning/jvm/method/TryWithResourcesOptTest
 *       15: dup
 *       16: ldc           #8                  // String Foo1
 *       18: invokespecial #7                  // Method "<init>":(Ljava/lang/String;)V
 *       21: astore_3
 *       22: aconst_null
 *       23: astore        4
 *       25: new           #5                  // class com/learning/jvm/method/TryWithResourcesOptTest
 *       28: dup
 *       29: ldc           #9                  // String Foo2
 *       31: invokespecial #7                  // Method "<init>":(Ljava/lang/String;)V
 *       34: astore        5
 *       36: aconst_null
 *       37: astore        6
 *       39: new           #3                  // class java/lang/RuntimeException
 *       42: dup
 *       43: ldc           #10                 // String Initial
 *       45: invokespecial #4                  // Method java/lang/RuntimeException."<init>":(Ljava/lang/String;)V
 *       48: athrow
 *       49: astore        7
 *       51: aload         7
 *       53: astore        6
 *       55: aload         7
 *       57: athrow
 *       58: astore        8
 *       60: aload         5
 *       62: ifnull        95
 *       65: aload         6
 *       67: ifnull        90
 *       70: aload         5
 *       72: invokevirtual #12                 // Method close:()V
 *       75: goto          95
 *       78: astore        9
 *       80: aload         6
 *       82: aload         9
 *       84: invokevirtual #13                 // Method java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
 *       87: goto          95
 *       90: aload         5
 *       92: invokevirtual #12                 // Method close:()V
 *       95: aload         8
 *       97: athrow
 *       98: astore        5
 *      100: aload         5
 *      102: astore        4
 *      104: aload         5
 *      106: athrow
 *      107: astore        10
 *      109: aload_3
 *      110: ifnull        141
 *      113: aload         4
 *      115: ifnull        137
 *      118: aload_3
 *      119: invokevirtual #12                 // Method close:()V
 *      122: goto          141
 *      125: astore        11
 *      127: aload         4
 *      129: aload         11
 *      131: invokevirtual #13                 // Method java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
 *      134: goto          141
 *      137: aload_3
 *      138: invokevirtual #12                 // Method close:()V
 *      141: aload         10
 *      143: athrow
 *      144: astore_3
 *      145: aload_3
 *      146: astore_2
 *      147: aload_3
 *      148: athrow
 *      149: astore        12
 *      151: aload_1
 *      152: ifnull        181
 *      155: aload_2
 *      156: ifnull        177
 *      159: aload_1
 *      160: invokevirtual #12                 // Method close:()V
 *      163: goto          181
 *      166: astore        13
 *      168: aload_2
 *      169: aload         13
 *      171: invokevirtual #13                 // Method java/lang/Throwable.addSuppressed:(Ljava/lang/Throwable;)V
 *      174: goto          181
 *      177: aload_1
 *      178: invokevirtual #12                 // Method close:()V
 *      181: aload         12
 *      183: athrow
 *     Exception table:
 *        from    to  target type
 *           39    49    49   Class java/lang/Throwable
 *           70    75    78   Class java/lang/Throwable
 *           39    60    58   any
 *           25    98    98   Class java/lang/Throwable
 *          118   122   125   Class java/lang/Throwable
 *           25   109   107   any
 *           12   144   144   Class java/lang/Throwable
 *          159   163   166   Class java/lang/Throwable
 *           12   151   149   any
 * }
 */
