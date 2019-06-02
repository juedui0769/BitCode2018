package com.wxg.socket.old;

import com.wxg.util.CommonConstants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 2019年1月3日13:54:24
 * from 《看透Spring MVC: 源代码分析与实践》, 4.1节
 */
public class Server {
    public static void main(String[] args) throws IOException {
        // 创建一个`ServerSocket`监听端口`8080`
        ServerSocket server = new ServerSocket(CommonConstants.PROT);
        // 等待请求
        Socket socket = server.accept();
        // 接收到请求后使用`socket`进行通信
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = br.readLine();
        System.out.println("received from client : " + line);
        //
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        pw.println("received data : " + line);
        pw.flush();
        //
        pw.close();
        br.close();
        socket.close();
        server.close();
    }
}
