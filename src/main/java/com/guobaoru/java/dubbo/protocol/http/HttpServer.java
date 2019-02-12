package com.guobaoru.java.dubbo.protocol.http;

import org.apache.catalina.Engine;
import org.apache.catalina.Host;
import org.apache.catalina.Server;
import org.apache.catalina.Service;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.startup.Tomcat;

/**
 * @author Created by guobaoru.
 * @create on 2019/1/14.
 */
public class HttpServer {

    public void start(String hostname, Integer port) {

        Tomcat tomcat = new Tomcat();

        Server server = tomcat.getServer();

        Service service = server.findService("Tomcat");

        Connector connector = new Connector();
        connector.setPort(port);

        Engine engine = new StandardEngine();
        engine.setDefaultHost(hostname);

        // .....

//        tomcat.addServlet();



    }
}
