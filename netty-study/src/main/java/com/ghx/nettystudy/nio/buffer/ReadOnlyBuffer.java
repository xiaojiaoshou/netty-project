package com.ghx.nettystudy.nio.buffer;

import java.nio.IntBuffer;

/**
 * 只读buffer
 */
public class ReadOnlyBuffer {
    public static void main(String[] args) {
        IntBuffer buffer = IntBuffer.allocate(10);
        buffer.put(1);
        buffer.put(2);
        buffer.put(3);
        buffer.put(4);
        buffer.put(5);

        buffer.flip();
        IntBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();

        while (readOnlyBuffer.hasRemaining()) {
            System.out.println(readOnlyBuffer.get());
        }

        // if you change data  throws ReadOnlyBufferException

        // readOnlyBuffer.put(6);

    }
}
