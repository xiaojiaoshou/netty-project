package com.ghx.nettystudy.nio.buffer;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 堆外内存修改，减少两次拷贝，效率更高。
 */
public class MappedBufferTest {
    public static void main(String[] args) throws Exception {
        RandomAccessFile randomAccess = new RandomAccessFile("F:\\test\\file01.txt", "rw");

        FileChannel channel = randomAccess.getChannel();
        /**
         * 参数1：FileChannel.MapMode.READ_WRITE 可读可写
         * 参数2：从那个位置开始
         * 参数3： 个数，
         */
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        mappedByteBuffer.put(0, (byte) 'h');
        mappedByteBuffer.put(1, (byte) 'h');
        mappedByteBuffer.put(2, (byte) 'h');
        mappedByteBuffer.put(3, (byte) 'h');
        mappedByteBuffer.put(4, (byte) 'h');


        randomAccess.close();

    }
}
