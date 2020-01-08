package com.mlh.learning.chat.clientSingleTalkChat.server.handler;

import com.mlh.learning.chat.clientSingleTalkChat.protocol.request.CreateGroupRequestPacket;
import com.mlh.learning.chat.clientSingleTalkChat.protocol.response.CreateGroupResponsePacket;
import com.mlh.learning.chat.clientSingleTalkChat.util.IDUtil;
import com.mlh.learning.chat.clientSingleTalkChat.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;

import java.util.ArrayList;
import java.util.List;

@ChannelHandler.Sharable
public class CreateGroupRequestHandler extends SimpleChannelInboundHandler<CreateGroupRequestPacket> {

    public static final CreateGroupRequestHandler INSTANCE = new CreateGroupRequestHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupRequestPacket msg) throws Exception {
         //1 创建userId列表 -> channels 作为群组，生成群组id,放到map里面
         //2 赛选待加入群聊的用户的channel和userName
         //3 创建对创建群组的response
         //4 给每个客户端发送群通知
        //5 将群聊信息(groupId -> channelGroup)保存在map主

        List<String> userIdList = msg.getUserIdList();

        List<String> userNameList = new ArrayList<>();

        //ChannelGroup
        ChannelGroup channelGroup = new DefaultChannelGroup(ctx.executor());

        //2. 将channel加入channelGroup 将userName 加入userNamegroup
        userIdList.forEach(userId -> {
            Channel channel = SessionUtil.getChannel(userId);
            if(channel != null){
                channelGroup.add(channel);
                userNameList.add(SessionUtil.getSession(channel).getUserName());
            }
        });

        //3
        String groupId = IDUtil.randomId();
        CreateGroupResponsePacket createGroupResponsePacket = new CreateGroupResponsePacket();
        createGroupResponsePacket.setSuccess(true);
        createGroupResponsePacket.setGroupId(groupId);
        createGroupResponsePacket.setUserNameList(userNameList);

        // 4
        channelGroup.writeAndFlush(createGroupResponsePacket);

        System.out.println("创建群聊成功 id为:["+groupId+"]");
        System.out.println("群组成员为:"+userNameList);

        // 5. 保存群组相关的信息
        SessionUtil.bindChannelGroup(groupId, channelGroup);
    }
}
