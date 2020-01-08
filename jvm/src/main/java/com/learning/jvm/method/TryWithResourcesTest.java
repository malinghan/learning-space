package com.learning.jvm.method;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author : linghan.ma
 * @Package com.learning.jvm.method
 * @Description:
 * @date Date : 2019年07月26日 2:49 PM
 **/
public class TryWithResourcesTest {
    public static void main(String[] args)  throws Exception{
        FileInputStream in0 = null;
        FileInputStream in1 = null;
        FileInputStream in2 = null;
        try {
            in0 = new FileInputStream(new File("in0.txt"));
            try {
                in1 = new FileInputStream(new File("in1.txt"));
                try {
                    in2 = new FileInputStream(new File("in2.txt"));
                } finally {
                    if (in2 != null){
                        in2.close();
                    }
                }
            } finally {
                if (in1 != null){
                    in1.close();
                }
            }
        } finally {
            if (in0 != null){
                in0.close();
            }
        }


    }
}
