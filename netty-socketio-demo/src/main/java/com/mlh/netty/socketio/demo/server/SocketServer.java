package com.mlh.netty.socketio.demo.server;

/**
 * @author : linghan.ma
 * @Package com.mlh.netty.socketio.demo.server
 * @Description:
 * @date Date : 2020年01月03日 11:04 AM
 **/

import ch.qos.logback.core.net.server.ServerRunner;
import com.corundumstudio.socketio.SocketIOServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * SpringBoot启动之后执行
 *
 * @author wliduo[i@dolyw.com]
 * @date 2019/4/17 11:45
 */
@Component
@Order(1)
public class SocketServer implements CommandLineRunner {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ServerRunner.class);

    /**
     * socketIOServer
     */
    private final SocketIOServer socketIOServer;

    @Autowired
    public SocketServer(SocketIOServer socketIOServer) {
        this.socketIOServer = socketIOServer;
    }

    @Override
    public void run(String... args) {
        logger.info("---------- NettySocket通知服务开始启动 ----------");
        socketIOServer.start();
        logger.info("---------- NettySocket通知服务启动成功 ----------");
    }

}