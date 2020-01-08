package com.mlh.learning.chat.pipelineTest.server.handler;

import com.mlh.learning.chat.pipelineTest.protocol.request.LoginRequestPacket;
import com.mlh.learning.chat.pipelineTest.protocol.response.LoginResponsePacket;
import com.mlh.learning.chat.pipelineTest.util.LoginUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;

public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket msg){
        //response
        System.out.println("LoginRequestHandler channelRead0...");
        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(loginResponsePacket.getVersion());

        if (valid(msg)) {
            loginResponsePacket.setSuccess(true);
            LoginUtil.markAsLogin(ctx.channel());
            System.out.println(new Date() + ": 登录成功!");
        } else {
            loginResponsePacket.setReason("账号密码校验失败");
            loginResponsePacket.setSuccess(false);
            System.out.println(new Date() + ": 登录失败!");
        }
        // 登录响应
        ctx.channel().writeAndFlush(loginResponsePacket);
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        if(loginRequestPacket.getUsername().equals("123")){
            System.out.println("Login UserName ...123");
        }
        return true;
    }
}
