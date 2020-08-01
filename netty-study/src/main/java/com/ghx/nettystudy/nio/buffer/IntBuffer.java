package com.ghx.nettystudy.nio.buffer;


public class IntBuffer {
    public static void main(String[] args) {

        java.nio.IntBuffer intBuffer = java.nio.IntBuffer.allocate(5);

        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i * 10);
        }
        intBuffer.flip();

        while (intBuffer.hasRemaining()) {

            System.out.println(intBuffer.get());
        }
    }
}
