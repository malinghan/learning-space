package com.mlh.learning.chat.pipelineTest.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class PacketEncoder extends MessageToByteEncoder<Packet> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Packet msg, ByteBuf out){
//             ctx.alloc().ioBuffer().writeBytes(PacketCodeC.INSTANCE.encode(msg));
        System.out.println("PacketEncoder encode...");
        PacketCodeC.INSTANCE.encode(out,msg);
    }
}
