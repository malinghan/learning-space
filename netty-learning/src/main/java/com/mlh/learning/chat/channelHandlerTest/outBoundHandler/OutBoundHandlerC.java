package com.mlh.learning.chat.channelHandlerTest.outBoundHandler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

public class OutBoundHandlerC extends ChannelOutboundHandlerAdapter {
    //ChannelHandlerContext ctx
    //read write

    @Override
    public void write(ChannelHandlerContext ctx, Object message, ChannelPromise channelPromise) throws Exception {
        System.out.println("OutBoundHandlerC:"+message);
        super.write(ctx,message,channelPromise);
    }
}
