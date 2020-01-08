package com.mlh.learning.chat.clientSingleTalkChat.client.console;

import com.mlh.learning.chat.clientSingleTalkChat.protocol.request.LoginRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

public class LoginConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.println("输入用户名登录:");
        LoginRequestPacket requestPacket = new LoginRequestPacket();

        requestPacket.setUserName(scanner.nextLine());
        requestPacket.setPassword("qqqq");

        channel.writeAndFlush(requestPacket);

        //不sleep会有什么影响？
        waitForLoginResponse();
    }

    private static void waitForLoginResponse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
    }
}
