package com.mlh.learning.chat.pipelineTest.protocol.response;


import com.mlh.learning.chat.pipelineTest.protocol.Command;
import com.mlh.learning.chat.pipelineTest.protocol.Packet;

public class MessageResponsePacket extends Packet {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return Command.MESSAGE_RESPONSE;
    }
}
