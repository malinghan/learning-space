package com.mlh.learning.chat.start;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Date;

/**
 * @author 闪电侠
 */
public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        //NioEventLoopGroup线程
        NioEventLoopGroup group = new NioEventLoopGroup();
        //bootstrap -> group;channel;handler
        bootstrap.group(group)
                //NioSocketChannel 客户端channel
                .channel(NioSocketChannel.class)
                //初始化ChannelHandler -> StringEncoder
                .handler(new ChannelInitializer<Channel>() {
                    //ChannelInitializer
                    @Override
                    protected void initChannel(Channel ch) {
                        ch.pipeline().addLast(new StringEncoder());
                    }
                });
        //客户端socket -> channel -> bootstrap.connect().channel
        Channel channel = bootstrap.connect("127.0.0.1", 8000).channel();

        while (true) {
            //每隔2s客户端向服务器发送写请求
            channel.writeAndFlush(new Date() + ": hello world!");
            Thread.sleep(2000);
        }
    }
}