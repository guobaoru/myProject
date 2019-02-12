package com.guobaoru.java.dubbo.provider;

import com.guobaoru.java.dubbo.protocol.http.HttpServer;

/**
 * @author Created by guobaoru.
 * @create on 2019/1/14.
 */
public class Provider {
    public static void main(String[] args) {

        // 本地注册

        // 注册中心

        // 启动tomcat 提供发现
        HttpServer httpServer = new HttpServer();
        httpServer.start("localhost", 8080);

    }
}
