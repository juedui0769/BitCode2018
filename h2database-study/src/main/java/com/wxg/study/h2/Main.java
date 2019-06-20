package com.wxg.study.h2;

import org.h2.engine.Constants;
import org.h2.server.TcpServer;
import org.h2.server.web.WebServer;

import java.sql.SQLException;

/**
 * {@link TcpServer}
 * {@link TcpServer#start()}
 * {@link TcpServer#listen()}
 *
 * {@link Constants#DEFAULT_HTTP_PORT}
 * {@link Constants#DEFAULT_TCP_PORT}
 *
 * {@link WebServer#start()}
 * {@link WebServer#listen()}
 * {@link WebServer#getURL()} <- 通过这个参数获取url : http://192.168.56.1:51883
 */
public class Main {

    public static void main(String[] args) throws SQLException {
//        Constants.DEFAULT_HTTP_PORT

//        TcpServer tcpServer = new TcpServer();
//        tcpServer.start();
//        tcpServer.listen();


        WebServer webServer = new WebServer();
        webServer.start();
        System.out.println(webServer.getURL());
        webServer.listen();
    }
}
