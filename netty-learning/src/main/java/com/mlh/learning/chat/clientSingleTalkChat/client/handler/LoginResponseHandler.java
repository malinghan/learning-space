package com.mlh.learning.chat.clientSingleTalkChat.client.handler;

import com.mlh.learning.chat.clientSingleTalkChat.protocol.response.LoginResponsePacket;
import com.mlh.learning.chat.clientSingleTalkChat.session.Session;
import com.mlh.learning.chat.clientSingleTalkChat.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 处理服务端登录响应
 */
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket msg) {
        String userId = msg.getUserId();
        String userName = msg.getUserName();

        if(msg.isSuccess()){
            System.out.println("[" + userName + "]登录成功，userId 为: " + msg.getUserId());
            SessionUtil.bindSession(new Session(userId,userName),ctx.channel());
        }else {
            //多种原因
            System.out.println("[" + userName + "]登录失败，原因：" + msg.getReason());
        }
    }
}
