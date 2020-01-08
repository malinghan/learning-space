package com.mlh.learning.chat.clientSingleTalkChat.protocol.response;


import com.mlh.learning.chat.clientSingleTalkChat.protocol.Packet;
import com.mlh.learning.chat.clientSingleTalkChat.session.Session;

import java.util.List;

import static com.mlh.learning.chat.clientSingleTalkChat.protocol.command.Command.LIST_GROUP_MEMBERS_RESPONSE;

public class ListGroupMembersResponsePacket extends Packet {

    private String groupId;

    private List<Session> sessionList;

    @Override
    public Byte getCommand() {

        return LIST_GROUP_MEMBERS_RESPONSE;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<Session> getSessionList() {
        return sessionList;
    }

    public void setSessionList(List<Session> sessionList) {
        this.sessionList = sessionList;
    }
}
