package com.guobaoru.java.io.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Created by guobaoru.
 * @create on 2018/8/29.
 */
public class SocketServerTest {
    public static void main(String[] args) throws IOException {

        int port = 8081;

        // 创建一个 ServerSocket ，可用于监听端口，接收socket
        ServerSocket socketServer = new ServerSocket(port);

        while (true) {
            Socket socket = socketServer.accept();
            InputStream in = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            System.out.println(br.readLine());
            br.close();
            in.close();
            socket.close();
        }

    }
}
