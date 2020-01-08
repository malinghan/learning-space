package com.mlh.learning.demo.test1;

public class ServerBoot {

    public static void main(String[] args) {
        Server server = new Server(Client.PORT);
        server.start();
    }
}
