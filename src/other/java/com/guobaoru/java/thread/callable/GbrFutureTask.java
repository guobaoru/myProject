package com.guobaoru.java.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Created by guobaoru.
 * @create on 2018/11/19.
 */
public class GbrFutureTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 通常
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();


        // 返回值
        Callable<String> callable = new Callable<String>(){
            @Override
            public String call() throws Exception {
                String threadName = Thread.currentThread().getName();
                System.out.println("线程 " + threadName + " is running");
                return "hello word!";
            }
        };

        FutureTask<String> task = new FutureTask<String>(callable);

        new Thread(task).start();

        // .get() 会等待执行结果
        System.out.println(task.get());
        String threadName = Thread.currentThread().getName();
        System.out.println("线程 " + threadName + " 执行完成");

    }
}
