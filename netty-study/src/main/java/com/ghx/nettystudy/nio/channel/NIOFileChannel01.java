package com.ghx.nettystudy.nio.channel;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 本地文件写（写入数据到文件）
 * buffer ->channerl->stream
 */
public class NIOFileChannel01 {

    public static void main(String[] args) throws Exception {
        String str = "你好，小姐姐";
        // 创建文件输出流
        FileOutputStream fileOutputStream = new FileOutputStream("F:\\test\\file01.txt");
        // 获取fileChannel
        FileChannel channel = fileOutputStream.getChannel();
        // 创建缓冲区buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // 将文字写入缓冲区
        byteBuffer.put(str.getBytes());
        // 重置缓冲区
        byteBuffer.flip();
        // 将缓冲区数据写入channel
        channel.write(byteBuffer);
        // 关闭流
        fileOutputStream.close();
    }
}
