package com.mlh.learning.chat.clientSingleTalkChat.protocol.request;


import com.mlh.learning.chat.clientSingleTalkChat.protocol.Packet;

import java.util.List;

import static com.mlh.learning.chat.clientSingleTalkChat.protocol.command.Command.CREATE_GROUP_REQUEST;

/**
 * 创建群聊请求
 */
public class CreateGroupRequestPacket extends Packet {

    private List<String> userIdList;

    @Override
    public Byte getCommand() {

        return CREATE_GROUP_REQUEST;
    }

    public List<String> getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(List<String> userIdList) {
        this.userIdList = userIdList;
    }

    @Override
    public String toString() {
        return "CreateGroupRequestPacket{" +
                "userIdList=" + userIdList +
                '}';
    }
}
