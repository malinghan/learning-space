package com.mlh.learning.chat.clientSingleTalkChat.protocol.response;


import com.mlh.learning.chat.clientSingleTalkChat.protocol.Packet;
import com.mlh.learning.chat.clientSingleTalkChat.session.Session;

import static com.mlh.learning.chat.clientSingleTalkChat.protocol.command.Command.GROUP_MESSAGE_RESPONSE;

public class GroupMessageResponsePacket extends Packet {

    private String fromGroupId;

    private Session fromUser;

    private String message;

    @Override
    public Byte getCommand() {

        return GROUP_MESSAGE_RESPONSE;
    }

    public String getFromGroupId() {
        return fromGroupId;
    }

    public void setFromGroupId(String fromGroupId) {
        this.fromGroupId = fromGroupId;
    }

    public Session getFromUser() {
        return fromUser;
    }

    public void setFromUser(Session fromUser) {
        this.fromUser = fromUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
