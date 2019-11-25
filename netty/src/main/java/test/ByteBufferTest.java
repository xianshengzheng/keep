package test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

public class ByteBufferTest {
    public static void main(String args[]) throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(8888);
        serverChannel.socket().bind(inetSocketAddress);

        int messageLength = 2 + 3 + 4;

        ByteBuffer[] buffers = new ByteBuffer[3];

        buffers[0] = ByteBuffer.allocate(2);
        buffers[1] = ByteBuffer.allocate(3);
        buffers[2] = ByteBuffer.allocate(4);

        SocketChannel socketChannel = serverChannel.accept();

        while (true) {
            int byteRead = 0;
            while (byteRead < messageLength) {
                long r = socketChannel.read(buffers);
                byteRead += r;

                System.out.println("byteRead:" + byteRead);

                Arrays.asList(buffers).stream().map(buffer -> "position:" + buffer.position() + ", limit:" + buffer.limit()).forEach(System.out::println);
            }


            Arrays.asList(buffers).forEach(buffer -> {
                buffer.flip();
            });

            long byteWritten = 0;
            while (byteWritten < messageLength) {
                long write = socketChannel.write(buffers);
                byteWritten += write;
            }

            Arrays.asList(buffers).forEach(buffer -> {
                buffer.clear();
            });

            System.out.println("bytesRead: " + byteRead + ", bytesWritten: " + byteWritten + ", messageLength: " + messageLength);

        }


    }

}