package com.mlh.learning.chat.clientSingleTalkChat.client.handler;

import com.mlh.learning.chat.clientSingleTalkChat.protocol.request.HeartBeatRequestPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.TimeUnit;

public class HeartBeatTimerHandler extends ChannelInboundHandlerAdapter {

    //直接定义为空闲检测时间的三分之一
    private static final int HEARTBEAT_INTERVAL = 5;

    /**
     * 心跳检测
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        scheduleSendHeartBeat(ctx);

        super.channelActive(ctx);
    }

    /**
     * 循环检测服务端是否连接正常
     * @param ctx
     */
    private void scheduleSendHeartBeat(ChannelHandlerContext ctx) {
        //ctx.executor (current thread) -> schedule (timer) ->
        ctx.executor().schedule(() -> {

            if (ctx.channel().isActive()) {
                ctx.writeAndFlush(new HeartBeatRequestPacket());
                scheduleSendHeartBeat(ctx);
            }

        }, HEARTBEAT_INTERVAL, TimeUnit.SECONDS);
    }
}
