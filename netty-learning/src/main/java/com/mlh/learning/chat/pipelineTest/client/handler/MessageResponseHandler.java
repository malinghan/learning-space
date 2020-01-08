package com.mlh.learning.chat.pipelineTest.client.handler;

import com.mlh.learning.chat.pipelineTest.protocol.response.MessageResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

/**
 *
 */
public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageResponsePacket msg) throws Exception {
        System.out.println("MessageResponseHandler channelRead0...");
        System.out.println(new Date()+"收到服务端的消息："+msg.getMessage());
    }
}
