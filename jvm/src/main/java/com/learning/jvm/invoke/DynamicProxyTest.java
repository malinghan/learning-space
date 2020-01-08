package com.learning.jvm.invoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author : linghan.ma
 * @Package com.learning.jvm.method
 * @Description:
 * @date Date : 2019年08月14日 10:04 PM
 **/
public class DynamicProxyTest {

    interface IHello {
        void sayHello();
    }

    static class Hello implements IHello {
        @Override
        public void sayHello() {
            System.out.println("hello world");
        }
    }

    static class DynamicProxy implements InvocationHandler {

        Object originalObj;

        Object bind(Object originalObj) {
            this.originalObj = originalObj;
            return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(), originalObj.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("welcome");
            return method.invoke(originalObj, args);
        }
    }
    //com.learning.jvm.invoke.DynamicProxyTest$Hello@1517365b
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFields","true");
        IHello hello = (IHello) new DynamicProxy().bind(new Hello());
        hello.sayHello();
    }
}
/**
 * Classfile /Users/malinghan/IdeaProjects/learning-space/jvm/src/main/java/com/learning/jvm/method/DynamicProxyTest.class
 *   Last modified 2019-8-14; size 668 bytes
 *   MD5 checksum e60e01c284267e67ab881bfe32d62b61
 *   Compiled from "DynamicProxyTest.java"
 * public class com.learning.jvm.invoke.DynamicProxyTest
 *   minor version: 0
 *   major version: 52
 *   flags: ACC_PUBLIC, ACC_SUPER
 * Constant pool:
 *    #1 = Methodref          #10.#23        // java/lang/Object."<init>":()V
 *    #2 = Class              #24            // com/learning/jvm/method/DynamicProxyTest$DynamicProxy
 *    #3 = Methodref          #2.#23         // com/learning/jvm/method/DynamicProxyTest$DynamicProxy."<init>":()V
 *    #4 = Class              #25            // com/learning/jvm/method/DynamicProxyTest$Hello
 *    #5 = Methodref          #4.#23         // com/learning/jvm/method/DynamicProxyTest$Hello."<init>":()V
 *    #6 = Methodref          #2.#26         // com/learning/jvm/method/DynamicProxyTest$DynamicProxy.bind:(Ljava/lang/Object;)Ljava/lang/Object;
 *    #7 = Class              #27            // com/learning/jvm/method/DynamicProxyTest$IHello
 *    #8 = InterfaceMethodref #7.#28         // com/learning/jvm/method/DynamicProxyTest$IHello.sayHello:()V
 *    #9 = Class              #29            // com/learning/jvm/method/DynamicProxyTest
 *   #10 = Class              #30            // java/lang/Object
 *   #11 = Utf8               DynamicProxy
 *   #12 = Utf8               InnerClasses
 *   #13 = Utf8               Hello
 *   #14 = Utf8               IHello
 *   #15 = Utf8               <init>
 *   #16 = Utf8               ()V
 *   #17 = Utf8               Code
 *   #18 = Utf8               LineNumberTable
 *   #19 = Utf8               main
 *   #20 = Utf8               ([Ljava/lang/String;)V
 *   #21 = Utf8               SourceFile
 *   #22 = Utf8               DynamicProxyTest.java
 *   #23 = NameAndType        #15:#16        // "<init>":()V
 *   #24 = Utf8               com/learning/jvm/method/DynamicProxyTest$DynamicProxy
 *   #25 = Utf8               com/learning/jvm/method/DynamicProxyTest$Hello
 *   #26 = NameAndType        #31:#32        // bind:(Ljava/lang/Object;)Ljava/lang/Object;
 *   #27 = Utf8               com/learning/jvm/method/DynamicProxyTest$IHello
 *   #28 = NameAndType        #33:#16        // sayHello:()V
 *   #29 = Utf8               com/learning/jvm/method/DynamicProxyTest
 *   #30 = Utf8               java/lang/Object
 *   #31 = Utf8               bind
 *   #32 = Utf8               (Ljava/lang/Object;)Ljava/lang/Object;
 *   #33 = Utf8               sayHello
 * {
 *   public com.learning.jvm.invoke.DynamicProxyTest();
 *     descriptor: ()V
 *     flags: ACC_PUBLIC
 *     Code:
 *       stack=1, locals=1, args_size=1
 *          0: aload_0
 *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 *          4: return
 *       LineNumberTable:
 *         line 13: 0
 *
 *   public static void main(java.lang.String[]);
 *     descriptor: ([Ljava/lang/String;)V
 *     flags: ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=3, locals=2, args_size=1
 *          0: new           #2                  // class com/learning/jvm/method/DynamicProxyTest$DynamicProxy
 *          3: dup
 *          4: invokespecial #3                  // Method com/learning/jvm/method/DynamicProxyTest$DynamicProxy."<init>":()V
 *          7: new           #4                  // class com/learning/jvm/method/DynamicProxyTest$Hello
 *         10: dup
 *         11: invokespecial #5                  // Method com/learning/jvm/method/DynamicProxyTest$Hello."<init>":()V
 *         14: invokevirtual #6                  // Method com/learning/jvm/method/DynamicProxyTest$DynamicProxy.bind:(Ljava/lang/Object;)Ljava/lang/Object;
 *         17: checkcast     #7                  // class com/learning/jvm/method/DynamicProxyTest$IHello
 *         20: astore_1
 *         21: aload_1
 *         22: invokeinterface #8,  1            // InterfaceMethod com/learning/jvm/method/DynamicProxyTest$IHello.sayHello:()V
 *         27: return
 *       LineNumberTable:
 *         line 43: 0
 *         line 44: 21
 *         line 45: 27
 * }
 * SourceFile: "DynamicProxyTest.java"
 * InnerClasses:
 *      static #11= #2 of #9; //DynamicProxy=class com/learning/jvm/method/DynamicProxyTest$DynamicProxy of class com/learning/jvm/method/DynamicProxyTest
 *      static #13= #4 of #9; //Hello=class com/learning/jvm/method/DynamicProxyTest$Hello of class com/learning/jvm/method/DynamicProxyTest
 *      static #14= #7 of #9; //IHello=class com/learning/jvm/method/DynamicProxyTest$IHello of class com/learning/jvm/method/DynamicProxyTest
 */

