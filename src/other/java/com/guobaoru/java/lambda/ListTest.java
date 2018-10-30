package com.guobaoru.java.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Created by guobaoru.
 * @create on 2018/9/5.
 */
public class ListTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(128);
        for (int i = 1 ; i <= 64; i++) {
            list.add(i);
            list.add(i + 100);
        }

//        List<Integer> sorted = list.stream().sorted().collect(Collectors.toList());
//
//        System.out.println(sorted.toString());


    }
}
