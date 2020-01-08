package com.mlh.learning.chat.clientSingleTalkChat.protocol.request;


import com.mlh.learning.chat.clientSingleTalkChat.protocol.Packet;
import com.mlh.learning.chat.clientSingleTalkChat.protocol.command.Command;

/**
 * userId作为session中的一个属性保存,同时存储在channel的attr中,request的报文中不用传自己的userId
 */
public class LoginRequestPacket extends Packet {

    private String userName;

    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Byte getCommand() {
        return Command.LOGIN_REQUEST;
    }
}
