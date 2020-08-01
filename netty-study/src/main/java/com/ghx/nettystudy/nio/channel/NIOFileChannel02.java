package com.ghx.nettystudy.nio.channel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 文件输入流
 * stream->channel-buffer
 */
public class NIOFileChannel02 {

    public static void main(String[] args) throws Exception {
        File file = new File("F:\\test\\file01.txt");
        // 创建文件输入流
        FileInputStream fileInputStream = new FileInputStream(file);
        // 获取fileChannel
        FileChannel channel = fileInputStream.getChannel();
        // 创建缓冲区buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());
        // 将文字写入缓冲区
        channel.read(byteBuffer);
        // 将缓冲区数据输出控制台
        System.out.println(new String(byteBuffer.array()));
        // 关闭流
        fileInputStream.close();
    }
}
