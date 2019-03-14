package basejava.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Created by guobaoru.
 * @create on 2018/7/26.
 */
public class ThreadMain {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread1());

        thread1.start();
        thread2.start();

        final ThreadMain tt = new ThreadMain();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (ThreadMain.class) {
                    try {
                        ThreadMain.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("wait1");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (ThreadMain.class) {
                    ThreadMain.class.notify();
                    System.out.println("wait2");
                }
            }
        }).start();


        /**
         * 线程池
         * param 核心线程数 、 最大线程数 、 存活时间（未理解） 、 时间单位 、 存储线程的阻塞队列（初始值为5，当循环15次时，最大线程为5，有5个线程在跑，有5个存在阻塞队列中，剩余5个丢失，并报错）
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 10, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(5));

        for (int i = 0; i < 15; i++) {
            threadPoolExecutor.execute(new Thread1());
        }
    }


    public synchronized void test() {
    }
}
