package com.mlh.learning.chat.nettyServerStart;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

/**
 * 自动绑定递增端口
 */

public class NIOServer {
    public static void main(String[] args) {
        //服务端引导类,引导服务器的初始化、启动
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        //boss用于接收并注册新连接,线程组
        NioEventLoopGroup boss = new NioEventLoopGroup();
        //worker用于轮询客户端数据读请求
        NioEventLoopGroup worker = new NioEventLoopGroup();
        serverBootstrap
                //给引导类配置两大线程组:boos、worker
                .group(boss, worker)
                //指定IO通信模型
//                .channel(OioServerSocketChannel.class) //OIO模型
                .channel(NioServerSocketChannel.class)
                //
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    protected void initChannel(NioSocketChannel ch) {
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
                            @Override
                            protected void channelRead0(ChannelHandlerContext ctx, String msg) {
                                System.out.println(msg);
                            }
                        });
                    }
                });
        bind(serverBootstrap,8000);
    }

    private static void bind(final ServerBootstrap serverBootstrap, final int port) {
        serverBootstrap.bind(port).addListener(new GenericFutureListener<Future<? super Void>>() {
            public void operationComplete(Future<? super Void> future) {
                if (future.isSuccess()) {
                    System.out.println("端口[" + port + "]绑定成功!");
                } else {
                    System.err.println("端口[" + port + "]绑定失败!");
                    bind(serverBootstrap, port + 1);
                }
            }
        });
    }
}
