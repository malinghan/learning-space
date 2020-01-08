package com.mlh.learning.chat.channelHandlerTest.outBoundHandler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

public class OutBoundHandlerB extends ChannelOutboundHandlerAdapter {
    //ChannelHandlerContext ctx
    //read write

    @Override
    public void write(ChannelHandlerContext ctx, Object message, ChannelPromise channelPromise) throws Exception {
        System.out.println("OutBoundHandlerB:"+message);
        super.write(ctx,message,channelPromise);
    }
}
