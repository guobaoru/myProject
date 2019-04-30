package com.guobaoru.basejava.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Created by guobaoru.
 * @create on 2018/12/6.
 */
public class ReentrantLockDemo {
    /**
     * ReentrantLock 内部有个 继承 AbstractQueuedSynchronizer 的实例
     */
    private static ReentrantLock lock = new ReentrantLock();

    public static int i = 0;

    public static void main(String[] args) throws InterruptedException {

        /**
         * 线程计数器（10）等待10条线程只执行完成，再进行主线程执行
         * 但是使用时需要知道具体线程数，这个现实场景不可控吧？（遗留）
         */
        CountDownLatch latch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    new ReentrantLockDemo().add();
                }
                //每次执行完线程 进行 countDown
                latch.countDown();
            }).start();
        }

        // 等待 latch 扣减 完成
        latch.await();
        System.out.println(latch.getCount());
        System.out.println(ReentrantLockDemo.i);

    }


    /**
     * 自增方法
     */
    public void add() {
        lock.lock();
        ReentrantLockDemo.i++;
        lock.unlock();
    }
}
