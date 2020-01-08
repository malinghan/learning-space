package com.mlh.learning.chat.byteBuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.ByteProcessor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

import static jdk.nashorn.internal.objects.Global.println;

/**
 *  *  BEFORE clear()
 *  *
 *  *      +-------------------+------------------+------------------+
 *  *      | discardable bytes |  readable bytes  |  writable bytes  |
 *  *      +-------------------+------------------+------------------+
 *  *      |                   |                  |                  |
 *  *      0      <=      readerIndex   <=   writerIndex    <=    capacity
 *  *
 *  *
 *  *  AFTER clear()
 *  *
 *  *      +---------------------------------------------------------+
 *  *      |             writable bytes (got more space)             |
 *  *      +---------------------------------------------------------+
 *  *      |                                                         |
 *  *      0 = readerIndex = writerIndex            <=            capacity
 */
public class ByteBufTest{
    public static void main(String[] args) {
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer(9,100);
        //ByteBufAllocator.heapBuffer()
        print("allocate ByteBuf(9,100)",byteBuf);

        byteBuf.writeBytes(new byte[]{1,2,3,4});
        print("writeBytes(1,2,3,4)",byteBuf);

        byteBuf.writeInt(12);
        print("writeInt(12)",byteBuf);

        byteBuf.writeBytes(new byte[]{6});
        print("writeBytes(6)",byteBuf);

        // get 方法不改变读写指针
        System.out.println("getByte(3) return: " + byteBuf.getByte(3));
        System.out.println("getShort(3) return: " + byteBuf.getShort(3));
        System.out.println("getInt(3) return: " + byteBuf.getInt(3));
        print("getByte()", byteBuf);

        // set 方法不改变读写指针
        byteBuf.setByte(byteBuf.readableBytes() -1, 0);
        print("setByte()", byteBuf);

        // read 方法改变读指针
        byte[] dst = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(dst);
        print("readBytes(" + dst.length + ")", byteBuf);


    }

    private static void print(String action, ByteBuf buffer) {
        System.out.println("after ===========" + action + "============");
        System.out.println("capacity(): " + buffer.capacity());
        System.out.println("maxCapacity(): " + buffer.maxCapacity());
        System.out.println("readerIndex(): " + buffer.readerIndex());
        System.out.println("readableBytes(): " + buffer.readableBytes());
        System.out.println("isReadable(): " + buffer.isReadable());
        System.out.println("writerIndex(): " + buffer.writerIndex());
        System.out.println("writableBytes(): " + buffer.writableBytes());
        System.out.println("isWritable(): " + buffer.isWritable());
        System.out.println("maxWritableBytes(): " + buffer.maxWritableBytes());
        System.out.println();
    }
}
