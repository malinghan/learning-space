package com.mlh.learning.chat.start;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.sctp.oio.OioSctpServerChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.channel.socket.oio.OioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

/**
 * @author 闪电侠
 * @desc 启动一个服务器必须要 线程模型、IO模型、连接读写处理逻辑、绑定端口信息
 *
 * Nagle算法: 通俗地说，如果要求高实时性，有数据发送时就马上发送，就关闭，如果需要减少发送次数减少网络交互，就开启。
 */
public class NettyServer {
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
//                .attr(AttributeKey.newInstance("serverName"), "nettyServer")
//                .childAttr(AttributeKey.newInstance("clientKey"), "clientValue")
//                  .option(ChannelOption.SO_BACKLOG, 1024) //表示系统用于临时存放已完成三次握手的请求的队列的最大长度，如果连接建立频繁，服务器处理创建新连接较慢，可以适当调大这个参数
//                .childOption(ChannelOption.SO_KEEPALIVE, true)  //是否开启TCP底层心跳机制
//                .childOption(ChannelOption.TCP_NODELAY, true)  //是否开启Nagle算法
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
                })
                .bind(8000);
    }



    /**
     * 绑定后事件处理
     * @param serverBootstrap
     * @param port
     */
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


    /**
     * handle用于服务器处理新连接注册事件
     * childHandler 用于处理客户端读写事件
     * @param serverBootstrap
     */
    private static void handler(final ServerBootstrap serverBootstrap) {
        serverBootstrap.handler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {
                System.out.println("server start");
            }
        });
    }

    /**
     * 给 channel -> NioServerSocketChannel设置属性
     * @param serverBootstrap
     */
    private static void attr(final ServerBootstrap serverBootstrap) {
        //
        serverBootstrap.attr(AttributeKey.newInstance("serverName"), "nettyServer");
    }
}
