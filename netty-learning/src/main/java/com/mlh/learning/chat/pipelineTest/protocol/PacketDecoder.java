package com.mlh.learning.chat.pipelineTest.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * issue: ByteToMessageDecoder<Packet>
 *  由于是decode,所以输入是一个 ByteBuf 输出是Java Class Object
 */
public class PacketDecoder extends ByteToMessageDecoder {


    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List out) {
        System.out.println("PacketDecoder...");
        out.add(PacketCodeC.INSTANCE.decode(in));
    }
}
