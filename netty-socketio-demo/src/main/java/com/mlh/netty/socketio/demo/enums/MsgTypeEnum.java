package com.mlh.netty.socketio.demo.enums;

/**
 * @author : linghan.ma
 * @Package com.mlh.netty.socketio.demo.enums
 * @Description:
 * @date Date : 2020年01月03日 11:10 AM
 **/
public enum  MsgTypeEnum {
    ONLINE("online"),
    OFFLINE("offline");

    private String value;

    MsgTypeEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
