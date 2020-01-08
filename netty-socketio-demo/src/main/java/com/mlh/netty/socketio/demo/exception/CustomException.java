package com.mlh.netty.socketio.demo.exception;

/**
 * @author : linghan.ma
 * @Package com.mlh.netty.socketio.demo.exception
 * @Description:
 * @date Date : 2020年01月03日 11:17 AM
 **/
public class CustomException extends RuntimeException {
    public CustomException(String msg){
        super(msg);
    }

    public CustomException() {
        super();
    }
}
