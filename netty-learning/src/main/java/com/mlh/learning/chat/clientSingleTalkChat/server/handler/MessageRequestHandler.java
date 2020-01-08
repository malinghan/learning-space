package com.mlh.learning.chat.clientSingleTalkChat.server.handler;

import com.mlh.learning.chat.clientSingleTalkChat.protocol.request.MessageRequestPacket;
import com.mlh.learning.chat.clientSingleTalkChat.protocol.response.MessageResponsePacket;
import com.mlh.learning.chat.clientSingleTalkChat.session.Session;
import com.mlh.learning.chat.clientSingleTalkChat.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

@ChannelHandler.Sharable
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {

    public static final MessageRequestHandler INSTANCE = new MessageRequestHandler();

    /**
     * 这部分很关键,用于连接两个客户端信息交流
     * A -request-> server -response-> B
     * server : sessionChannelMap
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket msg) throws Exception {

        System.out.println("MessageRequestPacket:"+msg);
        //1. 获取消息发送方的会话信息session
        Session session = SessionUtil.getSession(ctx.channel());

        //2. 通过session构造发送的消息
        MessageResponsePacket messageResponsePacket = new MessageResponsePacket();
        messageResponsePacket.setFromUserId(session.getUserId());
        messageResponsePacket.setFromUserName(session.getUserName());
        messageResponsePacket.setMessage(msg.getMessage());

        //3. 拿到消息接收方的channel
        Channel toUserChannel = SessionUtil.getChannel(msg.getToUserId());

        System.out.println(session);

        //4. 将消息发送给消息接收方
        if(toUserChannel != null && SessionUtil.hasLogin(toUserChannel)){
            System.out.println("messageResponsePacket:"+messageResponsePacket);
            toUserChannel.writeAndFlush(messageResponsePacket).addListener(future -> {
                if(future.isDone()){
                    //统计处理时长
                    System.out.println(new Date()+": message send complete");
                }
            });
        }else {
            System.err.println("[" + msg.getToUserId() + "] 不在线，发送失败!");
        }
    }
}
