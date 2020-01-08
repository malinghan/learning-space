package com.mlh.learning.chat.clientSingleTalkChat.attribute;

import com.mlh.learning.chat.clientSingleTalkChat.session.Session;
import io.netty.util.AttributeKey;

public interface Attributes {
    //记录用户登录信息
    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}
