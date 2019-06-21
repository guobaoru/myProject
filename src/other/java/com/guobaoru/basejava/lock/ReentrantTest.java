package com.guobaoru.basejava.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * debug 查看state 在重入的过程中 逐步 +1
 *
 * @version 1.0
 * @author: guobaoru
 * @date: 2019/6/17 19:45
 */
public class ReentrantTest {
    Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        ReentrantTest reentrantTest = new ReentrantTest();
        reentrantTest.test();
    }

    public void test() {
        lock.lock();
        System.out.println("1111");
        test2();
        lock.unlock();
    }

    public void test2() {
        lock.lock();
        System.out.println("2222");
        lock.unlock();
    }

}
