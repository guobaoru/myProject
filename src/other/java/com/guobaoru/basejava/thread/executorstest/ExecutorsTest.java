package com.guobaoru.basejava.thread.executorstest;

import java.util.concurrent.*;

/**
 * @author Created by guobaoru.
 * @create on 2018/9/13.
 */
public class ExecutorsTest {
    public static void main(String[] args) {
        /**
         * 核心线程和最大线程都是5，多余的线程会在等待队列中
         * 等待队列内存不可控
         * new LinkedBlockingQueue<Runnable>()
         */
        ExecutorService executor = Executors.newFixedThreadPool(5);
        /**
         * 核心线程和最大线程都是1，多余的线程会在等待队列中
         * 等待队列内存不可控
         * new LinkedBlockingQueue<Runnable>()
         */
        ExecutorService executor1 = Executors.newSingleThreadExecutor();
        /**
         * 核心线程是 0 最大线程 Integer.MAX_VALUE
         * 线程数会随着并发一直增加到 Max 也会导致内存溢出
         * new SynchronousQueue<Runnable>()
         */
        ExecutorService executor2 = Executors.newCachedThreadPool();
        /**
         * 核心线程是 5 最大线程 Integer.MAX_VALUE
         * new DelayedWorkQueue()
         */
        ExecutorService executor3 = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 10; i++) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    try {

                        Thread.sleep(500);
                        System.out.println("lalalala");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }


        for (int i = 0; i < 5; i++) {
            Future future = executor.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(500);
                    return 1;
                }
            });
//            try {
//                System.out.println(future.get());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
        }


        System.out.println("done");

    }
}
