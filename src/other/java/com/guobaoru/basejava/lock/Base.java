package basejava.lock;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Created by guobaoru.
 * @create on 2018/12/6.
 */
public class Base {
    public static void main(String[] args) {
        /**
         * ReentrantLock 内部有个 继承 AbstractQueuedSynchronizer 的实例
         */
        ReentrantLock lock = new ReentrantLock();


        lock.lock();


        lock.unlock();

    }
}
