package basejava.thread.common;

import java.util.concurrent.*;

/**
 * @author Created by guobaoru.
 * @create on 2018/9/13.
 */
public class CommonTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

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
