package com.mlh.learning.chat.pipelineTest.server.handler;

import com.mlh.learning.chat.pipelineTest.protocol.request.MessageRequestPacket;
import com.mlh.learning.chat.pipelineTest.protocol.response.MessageResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {

    /**
     * 服务端 处理客户端请求
     * @param ctx
     * @param msg
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket msg){
        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        System.out.println(new Date()+": 收到客户端消息: "+messageResponsePacket.getMessage());
        messageResponsePacket.setMessage("服务端回复消息【"+messageResponsePacket.getMessage()+"】");
        ctx.channel().writeAndFlush(messageResponsePacket);
    }
}
