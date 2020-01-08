package com.mlh.learning.demo.test1;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static final int PORT = 8888;
    public static final String HOST = "127.0.0.1";
    public static final int SLEEP_TIME = 5000;

    public static void main(String[] args) {
        //定义一个 socket
        Socket socket;
          while (true){
              try {
                  String message = "我是你爸爸";
                  socket = new Socket(HOST,PORT);
                  System.out.println("socket start");
                  socket.getOutputStream().write(message.getBytes());
              }catch (IOException e){
                  System.out.println("socket客户端连接出现问题!");
                  e.printStackTrace();
              }
              sleep(SLEEP_TIME);
          }
    }

    private static void sleep(int time){
        try {
            Thread.sleep(time);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
