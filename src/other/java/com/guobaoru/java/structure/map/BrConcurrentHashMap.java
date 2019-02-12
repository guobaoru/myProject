package com.guobaoru.java.structure.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Created by guobaoru.
 * @create on 2018/11/28.
 */
public class BrConcurrentHashMap {
    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        System.out.println(16 >>> 16);
        int n = 24;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        System.out.println((n < 0) ? 1 : (n >= 1000000) ? 1000000 : n + 1);
    }
}


