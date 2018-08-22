package com.guobaoru.algorithm.tree;

public class Test {

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        Test2 test2 = new Test2();
        Thread thread = new Thread(test1);
        Thread thread2 = new Thread(test2);
        thread.start();
        thread2.start();
    }
}

class Test1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}

class Test2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}
