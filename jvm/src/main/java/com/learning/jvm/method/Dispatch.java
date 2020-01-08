package com.learning.jvm.method;

/**
 * @author : linghan.ma
 * @Package com.learning.jvm.method
 * @Description:
 * @date Date : 2019年07月26日 2:58 AM
 **/
/**
 * 单分派、多分派演示
 * @author zzm
 */
public class Dispatch {

    static class QQ {}

    static class _360 {}

    public static class Father {

        public void hardChoice(QQ arg) {
            System.out.println("father choose qq");
        }

        public void hardChoice(_360 arg) {
            System.out.println("father choose 360");
        }
    }

    public static class Son extends Father {

        @Override
        public void hardChoice(QQ arg) {
            System.out.println("son choose qq");
        }

        @Override
        public void hardChoice(_360 arg) {
            System.out.println("son choose 360");
        }
    }

    public static void main(String[] args) {
        // 左边的类型是要么和右边的一样、要么是右边的父类、要么是右边的接口
        Father father = new Father();
        Father son = new Son();
//        Son son1 = new Father();
        father.hardChoice(new _360());
        son.hardChoice(new QQ());
    }
}
