package com.mlh.learning.chat.clientSingleTalkChat.server.handler;

import com.mlh.learning.chat.clientSingleTalkChat.protocol.request.LogoutRequestPacket;
import com.mlh.learning.chat.clientSingleTalkChat.protocol.response.LogoutResponsePacket;
import com.mlh.learning.chat.clientSingleTalkChat.util.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 登出请求
 */
@ChannelHandler.Sharable
public class LogoutRequestHandler extends SimpleChannelInboundHandler<LogoutRequestPacket> {

    public static final LogoutRequestHandler INSTANCE = new LogoutRequestHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogoutRequestPacket msg) {
        SessionUtil.unBindSession(ctx.channel());
        LogoutResponsePacket logoutResponsePacket = new LogoutResponsePacket();
        logoutResponsePacket.setSuccess(true);
//        ctx.channel().writeAndFlush(logoutResponsePacket);
        ctx.writeAndFlush(logoutResponsePacket);
    }
}
