package com.mlh.learning.guava;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.internal.matchers.InstanceOf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {

   @Test
    public void testLinkedList(){
        List<String> aaa = new ArrayList<>();
       aaa.add("sasa");
       aaa.add("ccs");
       System.out.println((LinkedList<String>) aaa);
    }

    @Test
    public void testLinkedListGuava(){
        List<String> aaa = new ArrayList<>();
        aaa.add("sasa");
        aaa.add("ccs");
        System.out.println(Lists.newLinkedList(aaa));
    }
}
