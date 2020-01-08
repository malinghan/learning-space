package com.mlh.learning.chat.clientSingleTalkChat.protocol.request;

import com.mlh.learning.chat.clientSingleTalkChat.protocol.Packet;

import static com.mlh.learning.chat.clientSingleTalkChat.protocol.command.Command.LOGOUT_REQUEST;

/**
 * 退出登录 -？
 */
public class LogoutRequestPacket extends Packet {
    @Override
    public Byte getCommand() {

        return LOGOUT_REQUEST;
    }
}
