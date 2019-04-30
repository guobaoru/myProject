package com.guobaoru.basejava.concurrency.synchronize;

public class TestDemo {
    public static int i = 0;

    /**
     * 锁住的是对象，当多个对象进行并发操作时，线程不安全
     */
    public synchronized void increase1() {
        i++;
    }

    public void increase2() {
        synchronized (this) {
            i++;
        }
    }

    /**
     * 锁住的是类对象，这个类new出来的都是安全的
     */
    public void increase3() {
        synchronized (TestDemo.class) {
            i++;
        }
    }

    public synchronized static void increase4() {
        i++;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        new TestDemo().increase1();
                    }
                }
            }).start();
        }


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(i);

    }
}
