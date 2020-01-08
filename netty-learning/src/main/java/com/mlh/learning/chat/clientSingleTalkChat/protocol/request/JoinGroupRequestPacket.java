package com.mlh.learning.chat.clientSingleTalkChat.protocol.request;



import com.mlh.learning.chat.clientSingleTalkChat.protocol.Packet;

import static com.mlh.learning.chat.clientSingleTalkChat.protocol.command.Command.JOIN_GROUP_REQUEST;

/**
 * 加入群聊请求
 */
public class JoinGroupRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {

        return JOIN_GROUP_REQUEST;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}
