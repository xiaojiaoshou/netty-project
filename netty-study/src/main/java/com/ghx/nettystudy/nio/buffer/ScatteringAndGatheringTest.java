package com.ghx.nettystudy.nio.buffer;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * Scattering：将数据写入到buffer时，可以采用buffer数组，依次写入  [分散]
 * Gathering: 从buffer读取数据时，可以采用buffer数组，依次读
 */
public class ScatteringAndGatheringTest {

    public static void main(String[] args) throws Exception {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress socketAddress = new InetSocketAddress(7000);
        // 绑定到socket 端口
        serverSocketChannel.socket().bind(socketAddress);

        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);
        System.out.println("应用程序启动了监听7000端口,等待连接阻塞中...");
        SocketChannel socketChannel = serverSocketChannel.accept();
        System.out.println("有连接进入accept.....");
        int maxlength = 8;

        while (true) {
            System.out.println("等待读取数据阻塞中......");
            long read = socketChannel.read(byteBuffers);
            System.out.println("读取数据了.....read：=" + read);
            Arrays.asList(byteBuffers).stream().forEach(ByteBuffer::clear);

            // 反转
            Arrays.asList(byteBuffers).stream().forEach(ByteBuffer::flip);

            long write = 0;
            // 写回客户端
            System.out.println("等待写入数据.......");
            write = socketChannel.write(byteBuffers);
            System.out.println("写入数据.....write：=" + write);
            Arrays.asList(byteBuffers).stream().forEach(ByteBuffer::clear);

            System.out.println("写入数据完毕.......");

            Arrays.asList(byteBuffers).stream()
                    .forEach(item -> {
                        if (item.hasRemaining()) {
                            System.out.println("输入的数据:" + item);
                        }
                    });
            // 清空
            Arrays.asList(byteBuffers).stream().forEach(ByteBuffer::clear);
        }

    }
}
