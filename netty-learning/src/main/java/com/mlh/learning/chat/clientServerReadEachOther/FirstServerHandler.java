package com.mlh.learning.chat.clientServerReadEachOther;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;
import java.util.Date;

public class FirstServerHandler extends ChannelInboundHandlerAdapter {

    /**
     *
     * @param ctx
     * @param msg -> byteBuf
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println((new Date() + ": 服务端读到数据 -> " +byteBuf.toString(Charset.forName("utf-8"))));
    }

}
