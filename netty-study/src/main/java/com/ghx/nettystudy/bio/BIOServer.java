package com.ghx.nettystudy.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * BIO
 */
public class BIOServer {
    public static void main(String[] args) throws IOException {
        // 创建一个线程池
        ExecutorService executor = Executors.newCachedThreadPool();
        // 监听的端口
        ServerSocket serverSocket = new ServerSocket(6666);

        while (true) {
            System.out.println("等待连接.........");
            Socket socket = serverSocket.accept();
            System.out.println("有客户端连接.........");

            executor.execute(() -> {
                handler(socket);

            });

        }


    }

    private static void handler(Socket socket) {
        InputStream inputStream = null;
        try {

            inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];

            while (true) {
                System.out.println("等待消息.........");
                int read = inputStream.read(bytes);
                System.out.println("消息到达.........");
                if (read != -1) {
                    System.out.println("服务器收到消息：  " + new String(bytes));
                } else {
                    break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
