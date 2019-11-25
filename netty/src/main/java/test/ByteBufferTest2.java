package test;

import java.io.IOException;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;

/**
 * @author Eric
 * @Title: ByteBufferTest2
 * @date 2019/8/9 12:44
 * @Description: TODO
 */
public class ByteBufferTest2 {

    public static void main(String args[]) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        ServerSocket socket = ServerSocketChannel.open().socket();

    }
}
