package com.mlh.learning.demo.test1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket的server
 */
public class Server{

    private ServerSocket serverSocket;

    public Server(int port){
        try {
            serverSocket = new ServerSocket(port);
        }catch (IOException e){
            //
            System.out.println("绑定端口出现问题");
            e.printStackTrace();
        }
    }

    //启动server,处理
    public void start(){
        doStart();
        System.out.println("can be print?");
    }

    private void doStart(){
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                new ClientHandler(socket).start();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("server error");
            }
        }
    }
}
