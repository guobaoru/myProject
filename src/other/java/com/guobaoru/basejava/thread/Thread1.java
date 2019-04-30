package com.guobaoru.basejava.thread;

/**
 * @author Created by guobaoru.
 * @create on 2018/7/26.
 */
public class Thread1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}
