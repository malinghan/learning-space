package com.mlh.learning.chat.pipelineTest.util;

import com.mlh.learning.chat.pipelineTest.protocol.Attributes;
import io.netty.channel.Channel;
import io.netty.util.Attribute;

/**
 * 将Channel中attr设置登录标志、判断attrs中是否有登录标志
 */
public class LoginUtil {
    /**
     * 设置登录标志
     * @param channel
     */
    public static void markAsLogin(Channel channel) {
        channel.attr(Attributes.LOGIN).set(true);
    }

    /**
     * 是否登录
     * @param channel
     * @return
     */
    public static boolean hasLogin(Channel channel) {
        Attribute<Boolean> loginAttr = channel.attr(Attributes.LOGIN);

        return loginAttr.get() != null;
    }
}
