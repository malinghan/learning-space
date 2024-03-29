package com.mlh.learning.chat.clientSingleTalkChat.util;

import com.mlh.learning.chat.clientSingleTalkChat.attribute.Attributes;
import com.mlh.learning.chat.clientSingleTalkChat.session.Session;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionUtil {
    /**
     * 将session与channel的关系存储在map中
     */
    private static final Map<String, Channel> userIdChannelMap = new ConcurrentHashMap<>();

    private static final Map<String, ChannelGroup> groupIdChannelGroupMap = new ConcurrentHashMap<>();

    /**
     * 绑定session，将session添加到map中,token生效
     * @param session
     * @param channel
     */
    public static void bindSession(Session session, Channel channel) {
        userIdChannelMap.put(session.getUserId(), channel);
        channel.attr(Attributes.SESSION).set(session);
    }

    /**
     * 解绑session,将session移除map,token失效
     * @param channel
     */
    public static void unBindSession(Channel channel) {
        if (hasLogin(channel)) {
            userIdChannelMap.remove(getSession(channel).getUserId());
            channel.attr(Attributes.SESSION).set(null);
        }
    }

    /**
     * 判断是否登录
     * @param channel
     * @return
     */
    public static boolean hasLogin(Channel channel) {

        return channel.hasAttr(Attributes.SESSION);
    }

    /**
     * 获取session
     * @param channel
     * @return
     */
    public static Session getSession(Channel channel) {

        return channel.attr(Attributes.SESSION).get();
    }

    /**
     * 获取channel
     * @param userId
     * @return
     */
    public static Channel getChannel(String userId) {
        return userIdChannelMap.get(userId);
    }

    public static void bindChannelGroup(String groupId, ChannelGroup channelGroup) {
        groupIdChannelGroupMap.put(groupId, channelGroup);
    }

    public static ChannelGroup getChannelGroup(String groupId) {
        return groupIdChannelGroupMap.get(groupId);
    }

}
