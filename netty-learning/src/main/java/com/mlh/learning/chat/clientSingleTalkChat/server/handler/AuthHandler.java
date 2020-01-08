package com.mlh.learning.chat.clientSingleTalkChat.server.handler;

import com.mlh.learning.chat.clientSingleTalkChat.util.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 拦截器
 */

@ChannelHandler.Sharable
public class AuthHandler extends ChannelInboundHandlerAdapter {

    public static final AuthHandler INSTANCE = new AuthHandler();

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
        if(SessionUtil.hasLogin(ctx.channel())){
            ctx.pipeline().remove(this);
            super.channelRead(ctx,msg);
        }else {
            //登录验证不通过
            ctx.channel().close();
        }
    }
}
