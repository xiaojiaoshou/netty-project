package com.ghx.nettystudy.nio.channel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 拷贝
 * 利用channel 的transferFrom 方法完成拷贝
 */
public class NIOFileChannel04 {

    public static void main(String[] args) throws Exception {
        File orgFile = new File("F:\\test\\a1.jpg");
        File targetFile = new File("F:\\test\\a2.jpg");

        FileInputStream fileInputStream = new FileInputStream(orgFile);
        FileOutputStream fileOutputStream = new FileOutputStream(targetFile);

        FileChannel inputChannel = fileInputStream.getChannel();
        FileChannel outputChannel = fileOutputStream.getChannel();

        // 利用channel直接拷贝
        outputChannel.transferFrom(inputChannel, 0, inputChannel.size());

        fileInputStream.close();
        fileOutputStream.close();
    }
}
