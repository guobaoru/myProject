package basejava.thread;

/**
 * @author Created by guobaoru.
 * @create on 2018/8/1.
 */

/**
 * 当两个并发线程访问同一个对象object中的这个synchronized(this)同步代码块时，
 * 一个时间内只能有一个线程得到执行。另一个线程必须等待当前线程执行完这个代码
 * 块以后才能执行该代码块。
 */
public class Thread01 implements Runnable {

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " 进入Run方法");

        synchronized (this) {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
            }
        }
    }

    public static void main(String[] args) {
        Thread01 t01 = new Thread01();

        System.out.println("synchronized 关键字使用 \n--------------------------");

        Thread ta = new Thread(t01, "A");
        Thread tb = new Thread(t01, "B");

        ta.start();
        tb.start();
    }
}
