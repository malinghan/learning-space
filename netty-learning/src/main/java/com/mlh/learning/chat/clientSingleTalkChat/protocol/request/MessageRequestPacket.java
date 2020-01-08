package com.mlh.learning.chat.clientSingleTalkChat.protocol.request;


import com.mlh.learning.chat.clientSingleTalkChat.protocol.Packet;
import com.mlh.learning.chat.clientSingleTalkChat.protocol.command.Command;

public class MessageRequestPacket extends Packet {
    private String toUserId; // 发送给谁
    private String message;

    public MessageRequestPacket(){

    }

    public MessageRequestPacket(String toUserId,String message)
    {
        this.toUserId = toUserId;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_REQUEST;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    @Override
    public String toString() {
        return "MessageRequestPacket{" +
                "toUserId='" + toUserId + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
