package com.guobaoru.basejava.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version 1.0
 * @author: guobaoru
 * @date: 2019/6/17 17:29
 */
public class ConditionTest {

    Lock lock = new ReentrantLock();

    Condition conditionAdd = lock.newCondition();
    Condition conditionReduce = lock.newCondition();

    int i = 0;
    public static void main(String[] args) throws InterruptedException {
        System.out.println("----------start----------");
        ConditionTest test = new ConditionTest();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    test.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            new Thread(() -> {
                try {
                    test.reduce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }


    }

    public void reduce() throws InterruptedException {
        lock.lock();
        if (i == 0) {
            conditionReduce.await();
        }
        i--;
        conditionAdd.signal();
        lock.unlock();
        System.out.println("i reduce:" + i);
    }

    public void add() throws InterruptedException {
        lock.lock();
        if (i == 10) {
            conditionAdd.await();
        }
        i++;
        conditionReduce.signal();
        lock.unlock();
        System.out.println("i add:" + i);
    }

}
