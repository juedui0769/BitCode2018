package com.wxg.socket.old;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        String msg = "Client Data";
        // 创建一个`socket`，跟本机的`8080`端口连接
        Socket socket = new Socket("127.0.0.1", 8080);
        //
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // 发送数据
        pw.println(msg);
        pw.flush();
        // 接收数据
        String line = br.readLine();
        System.out.println("received from server : " + line);
        // 关闭资源
        pw.close();
        br.close();
        socket.close();
    }
}
