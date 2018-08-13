package com.guobaoru.algorithm;

//斐波那契数列求青蛙跳阶问题
public class Fibonacci {

    public static void main(String[] args) {
        long count = 20;
        long t1 = System.currentTimeMillis();
        System.out.println(fibo1(count));
        System.out.println("递归使用时间：" + (System.currentTimeMillis() - t1) + "ms");
        long t2 = System.currentTimeMillis();
        System.out.println(fibo2(count));
        System.out.println("循环使用时间：" + (System.currentTimeMillis() - t2) + "ms");
    }

    //递归
    public static long fibo1(long n){

        if(n <= 2){
            return deal0to2(n);
        }
        return fibo1(n - 1) + fibo1(n - 2);
    }

    //循环
    public static long fibo2(long n){

        if(n <= 2){
            return deal0to2(n);
        }

        long a = 1;
        long b = 2;
        long c = 0;
        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    //处理小于台阶数等于2的返回值
    private static long deal0to2(long n){
        if (n <= 0){
            return 0;
        } else {
            return n;
        }
    }
}
