package com.learning.jvm.classloader.passive;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author : linghan.ma
 * @Package com.learning.jvm.classloader.passive
 * @Description:
 * @date Date : 2019年08月13日 5:08 PM
 **/
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {

        ClassLoader myLoader = new ClassLoader() {
            //传入全限定名
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    //读取限定名
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    //获取字节流
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        //执行类加载
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass("com.learning.jvm.classloader.passive.ClassLoaderTest").newInstance();

        System.out.println(obj.getClass());
        System.out.println(obj instanceof ClassLoaderTest);
    }
}
