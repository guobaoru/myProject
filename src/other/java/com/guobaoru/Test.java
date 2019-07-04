package com.guobaoru;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Created by guobaoru.
 * @create on 2019/1/25.
 */
public class Test {

    public static void main(String[] args) {

        List list1 = new ArrayList();
        List list2 = new ArrayList();

        long l1 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            list1.add("a");
        }
        System.out.println("第一次执行时间：" + (System.currentTimeMillis() - l1));

        long l2 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            list2.add(0, "a");
        }
        System.out.println("第二次执行时间：" + (System.currentTimeMillis() - l2));

    }

}
