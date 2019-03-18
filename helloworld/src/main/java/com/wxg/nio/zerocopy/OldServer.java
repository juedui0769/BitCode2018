package com.wxg.nio.zerocopy;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class OldServer {
    private static final int PORT = 8899;
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            try {
                byte[] byteArray = new byte[4096];

                while (true) {

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
