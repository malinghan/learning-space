package com.mlh.learning.demo.test1;


import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 服务器处理客户端请求的封装
 *
 * 对传过来的请求进行处理
 *
 * 如何读字节流
 */
public class ClientHandler {

    public static final int MAX_READ = 1024;
    private final  Socket socket;

    public ClientHandler(Socket socket){
        this.socket = socket;
    }

    public   void start(){
        System.out.println("new client come in");
//       new Thread(() -> doStart()).start();
        //要start
        new Thread(new Runnable() {
            @Override
            public void run() {
                doStart();
            }
        }).start();
    }

    private  void doStart(){
            try {
                InputStream inputStream = socket.getInputStream();
                socket.setSoTimeout(1000);
                socket.setKeepAlive(true);
                while(true) {
                    byte[] data = new byte[MAX_READ];
                    int len;
                    while ((len = inputStream.read(data)) != -1){
                        String message = new String(data,0,len);
                        System.out.println("客户端传来消息:"+message);
                        socket.getOutputStream().write(data);
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
}
