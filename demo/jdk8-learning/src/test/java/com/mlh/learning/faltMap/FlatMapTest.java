package com.mlh.learning.faltMap;

import com.mlh.learning.completableFuture.FutureTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FlatMapTest {

    @org.junit.Test
    public void testFuture(){
        List<String> strings1 = Arrays.asList("1","2","3","4","5");
        List<String> strings2 = Arrays.asList("1","2","3","4","5");
        List<String> strings3 = Arrays.asList("1","2","3","4","5");
        List<String> strings4 = Arrays.asList("1","2","3","4","5");
        List<List<String>> sss = new ArrayList<>();
        sss.add(strings1);
        sss.add(strings2);
        sss.add(strings3);
        sss.add(strings4);
        List<String>  asd = sss.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(asd);
    }

    @org.junit.Test
    public void testFuture2(){
        List<String> strings1 = Arrays.asList("1","2","3","4","5");
        List<String> strings2 = Arrays.asList("1","2","3","4","5");
        List<String> strings3 = Arrays.asList("1","2","3","4","5");
        List<String> strings4 = Arrays.asList("1","2","3","4","5");
        List<List<String>> sss = new ArrayList<>();
        sss.add(strings1);
        sss.add(strings2);
        sss.add(strings3);
        sss.add(strings4);
        List<String>  asd = sss.stream().flatMap(s -> Stream.of(s).map(d -> d+"1")).collect(Collectors.toList());
        System.out.println(asd);
    }
}
