package com.mlh.learning.chat.pipelineTest.client.handler;

import com.mlh.learning.chat.pipelineTest.protocol.request.LoginRequestPacket;
import com.mlh.learning.chat.pipelineTest.protocol.response.LoginResponsePacket;
import com.mlh.learning.chat.pipelineTest.util.LoginUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Date;
import java.util.UUID;

/**
 * 处理loginResponse
 */
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

    @Override
    public void channelActive(ChannelHandlerContext ctx){
        //create LoginRequest 自动登录
        System.out.println("LoginResponseHandler channelActive....");
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();
        loginRequestPacket.setUserId(UUID.randomUUID().toString());
        loginRequestPacket.setUserId("abc");
        loginRequestPacket.setUsername("123");
        //写数据
        ctx.channel().writeAndFlush(loginRequestPacket);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket msg){
        System.out.println("LoginResponseHandler channelRead0...");
        if(msg.isSuccess()){
            //设置登录成功的标志
            LoginUtil.markAsLogin(ctx.channel());
            System.out.println(new Date()+" 客户端登录成功!");
        }else {
            System.out.println(new Date()+"：客户端登录失败，原因："+msg.getReason());
        }

    }
}
