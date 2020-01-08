package com.mlh.learning.chat.clientSingleTalkChat.client.handler;

import com.mlh.learning.chat.clientSingleTalkChat.protocol.response.LogoutResponsePacket;
import com.mlh.learning.chat.clientSingleTalkChat.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 客户端在channel取消attr session的传递
 */
public class LogoutResponseHandler extends SimpleChannelInboundHandler<LogoutResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogoutResponsePacket msg) {
        SessionUtil.unBindSession(ctx.channel());
    }
}
