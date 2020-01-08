package com.mlh.learning.chat.clientSingleTalkChat.client.console;

import com.mlh.learning.chat.clientSingleTalkChat.protocol.request.LogoutRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * 用户手动退出登录
 */
public class LogoutConsoleCommand implements  ConsoleCommand{
    @Override
    public void exec(Scanner scanner, Channel channel) {
        LogoutRequestPacket logoutRequestPacket = new LogoutRequestPacket();
        channel.writeAndFlush(logoutRequestPacket);
    }
}
