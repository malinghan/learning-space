package com.mlh.learning.chat.clientSingleTalkChat.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class IMIdleStateHandler extends IdleStateHandler {

    private static final int READER_IDLE_TIME = 15;

    /**
     * Super(READER_IDLE_TIME, 0, 0, TimeUnit.SECONDS);
     * 首先，我们观察一下 IMIdleStateHandler 的构造函数，他调用父类 IdleStateHandler 的构造函数，有四个参数，
     * 其中第一个表示读空闲时间，指的是在这段时间内如果没有数据读到，就表示连接假死；
     * 第二个是写空闲时间，指的是 在这段时间如果没有写数据，就表示连接假死；
     * 第三个参数是读写空闲时间，表示在这段时间内如果没有产生数据读或者写，就表示连接假死。写空闲和读写空闲为0，表示我们不关心者两类条件；
     * 最后一个参数表示时间单位。在我们的例子中，表示的是：如果 15 秒内没有读到数据，就表示连接假死。
     *
     * 连接假死之后会回调 channelIdle() 方法，我们这个方法里面打印消息，并手动关闭连接。
     */
    public IMIdleStateHandler(){
        super(READER_IDLE_TIME,0,0, TimeUnit.SECONDS);
    }

    /**
     * 处理连接假死的方法
     * @param ctx
     * @param evt
     * @throws Exception
     */
    @Override
    protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {
        super.channelIdle(ctx, evt);
    }
}
