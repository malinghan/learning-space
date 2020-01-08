package com.mlh.learning.chat.clientSingleTalkChat.client.handler;

import com.mlh.learning.chat.clientSingleTalkChat.protocol.response.MessageResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {

    /**
     * 处理服务器响应
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageResponsePacket msg) {
        String fromUserId = msg.getFromUserId();
        String fromUserName = msg.getFromUserName();

        System.out.println(fromUserId + ":" + fromUserName + " -> " + msg
                .getMessage());

    }
}
