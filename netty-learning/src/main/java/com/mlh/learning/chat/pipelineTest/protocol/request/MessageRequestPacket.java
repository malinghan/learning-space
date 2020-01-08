package com.mlh.learning.chat.pipelineTest.protocol.request;


import com.mlh.learning.chat.pipelineTest.protocol.Command;
import com.mlh.learning.chat.pipelineTest.protocol.Packet;

public class MessageRequestPacket extends Packet {
    private String message;

    public MessageRequestPacket(){

    }

    public MessageRequestPacket(String message){
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
}
