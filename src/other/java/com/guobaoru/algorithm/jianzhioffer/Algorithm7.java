package com.guobaoru.algorithm.jianzhioffer;

/**
 * @author Created by guobaoru.
 * @create on 2018/9/27.
 */
public class Algorithm7 {
    public static void main(String[] args) {
        System.out.println(Fibonacci(3));
        System.out.println(Fibonacci1(3));
    }

    /**
     * 递归
     *
     * @param n
     * @return
     */
    public static int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    /**
     * 循环
     *
     * @param n
     * @return
     */
    public static int Fibonacci1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int a = 0;
        int b = 1;
        int c = 0;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
