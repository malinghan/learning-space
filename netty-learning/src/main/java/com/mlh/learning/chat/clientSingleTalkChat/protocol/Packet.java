package com.mlh.learning.chat.clientSingleTalkChat.protocol;


import com.alibaba.fastjson.annotation.JSONField;

/**
 * 通信协议的封装
 *
 * |----|-|-|-|----|---------...|
 * |魔数|版本号|序列化算法|指令|数据长度|数据|
 * |4|1|1|1|4|N|
 */
public abstract class Packet {
    /**
     * 协议版本
     */
    @JSONField(deserialize = false, serialize = false)
    private Byte version  = 1;

    /**
     * 指令
     * @return
     */
    @JSONField(serialize = false)
    public  abstract Byte getCommand();

    public Byte getVersion() {
        return version;
    }

    public void setVersion(Byte version) {
        this.version = version;
    }
}
