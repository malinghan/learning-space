package com.mlh.learning.chat.clientSingleTalkChat.protocol.response;

import com.mlh.learning.chat.clientSingleTalkChat.protocol.Packet;

import java.util.List;

import static com.mlh.learning.chat.clientSingleTalkChat.protocol.command.Command.CREATE_GROUP_RESPONSE;

public class CreateGroupResponsePacket extends Packet {
    private boolean success;

    private String groupId;

    private List<String> userNameList;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<String> getUserNameList() {
        return userNameList;
    }

    public void setUserNameList(List<String> userNameList) {
        this.userNameList = userNameList;
    }

    @Override
    public Byte getCommand() {
        return CREATE_GROUP_RESPONSE;
    }

    @Override
    public String toString() {
        return "CreateGroupResponsePacket{" +
                "success=" + success +
                ", groupId='" + groupId + '\'' +
                ", userNameList=" + userNameList +
                '}';
    }
}
