package com.guobaoru.algorithm;

// 1 + 2  + 3 + ... + n 不使用循环和判断语句
public class one_two_n {

    public static int recursion(int a) {
        return a > 0 ? a + recursion(a - 1) : 0;    //也算是判断语句
    }

    public static int recursion1(int a) {
        boolean b = (a > 0) && ((a += recursion(a - 1)) > 0);
        return a;
    }

    public static void main(String[] args) {
        System.out.println(recursion(4));
        System.out.println(recursion1(4));
    }
}
