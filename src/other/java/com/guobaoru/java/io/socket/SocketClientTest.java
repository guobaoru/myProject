package com.guobaoru.java.io.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Created by guobaoru.
 * @create on 2018/8/29.
 */
public class SocketClientTest {
    public static void main(String[] args) throws IOException, InterruptedException {

        ExecutorService executors = Executors.newFixedThreadPool(2);

        executors.submit(new ThreadTest1());
        executors.submit(new ThreadTest2());

        executors.shutdown();

    }
}

class ThreadTest1 implements Callable {

    @Override
    public Object call() throws Exception {

        String host = "127.0.0.1";
        int port = 8081;
        Socket socket = new Socket(host, port);
        for (int i = 0; i < 10; i++) {
            String message = "你好：" + i;
            socket.getOutputStream().write(message.getBytes("UTF-8")); //这个地方需要close OutputStream么
        }
        Thread.sleep(3000);
        socket.close();
        return null;
    }
}

class ThreadTest2 implements Callable {

    @Override
    public Object call() throws Exception {

        String host = "127.0.0.1";
        int port = 8081;

        for (int i = 0; i < 10; i++) {
            Socket socket = new Socket(host, port);
            String message = "你好：" + i;
            OutputStream os = socket.getOutputStream();
            os.write(message.getBytes("UTF-8")); //这个地方需要close OutputStream么
            Thread.sleep(500);
            os.close();
            socket.close();
        }
        return null;
    }
}