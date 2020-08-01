package com.ghx.nettystudy.nio.channel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 文件拷贝
 */
public class NIOFileChannel03 {

    public static void main(String[] args) throws Exception {
        File orgFile = new File("F:\\test\\file01.txt");
        File targetFile = new File("F:\\test\\file02.txt");

        FileInputStream fileInputStream = new FileInputStream(orgFile);
        FileOutputStream fileOutputStream = new FileOutputStream(targetFile);

        FileChannel inputChannel = fileInputStream.getChannel();
        FileChannel outputChannel = fileOutputStream.getChannel();

        // 创建缓冲区buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        while (true) {
            byteBuffer.clear();
            int read = inputChannel.read(byteBuffer);

            if (read == -1) {
                break;
            }

            byteBuffer.flip();
            outputChannel.write(byteBuffer);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
