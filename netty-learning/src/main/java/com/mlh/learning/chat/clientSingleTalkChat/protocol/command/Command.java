package com.mlh.learning.chat.clientSingleTalkChat.protocol.command;

public interface Command {

    Byte LOGIN_REQUEST = 1;

    Byte LOGIN_RESPONSE = 2;

    Byte MESSAGE_REQUEST = 3;

    Byte MESSAGE_RESPONSE = 4;

    Byte LOGOUT_REQUEST = 5;

    Byte LOGOUT_RESPONSE = 6;

    Byte CREATE_GROUP_REQUEST = 7;

    Byte CREATE_GROUP_RESPONSE = 8;

    Byte LIST_GROUP_MEMBERS_REQUEST = 9; //列出群组成员请求

    Byte LIST_GROUP_MEMBERS_RESPONSE = 10; //列出群组成员响应

    Byte JOIN_GROUP_REQUEST = 11;  //加入群组

    Byte JOIN_GROUP_RESPONSE = 12; //加入群组

    Byte QUIT_GROUP_REQUEST = 13; //退出群组

    Byte QUIT_GROUP_RESPONSE = 14; //退出群组

    Byte GROUP_MESSAGE_REQUEST = 15; //群发消息

    Byte GROUP_MESSAGE_RESPONSE = 16;

    Byte HEARTBEAT_REQUEST = 17;

    Byte HEARTBEAT_RESPONSE = 18;
}
