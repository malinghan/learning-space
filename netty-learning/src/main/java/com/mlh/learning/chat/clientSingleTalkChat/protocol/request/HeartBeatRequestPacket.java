package com.mlh.learning.chat.clientSingleTalkChat.protocol.request;

import com.mlh.learning.chat.clientSingleTalkChat.protocol.Packet;

import static com.mlh.learning.chat.clientSingleTalkChat.protocol.command.Command.HEARTBEAT_REQUEST;

public class HeartBeatRequestPacket extends Packet {
    @Override
    public Byte getCommand() {
        return HEARTBEAT_REQUEST;
    }
}
