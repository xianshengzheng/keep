package test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * @author Eric
 * @Title: NioTest2
 * @date 2019/8/7 17:14
 * @Description: TODO
 */
public class NioServer {
    public static void main(String args[]) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(8899));

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        Map<SocketChannel, String> registered = new HashMap();
        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            for (SelectionKey selectionKey : selectionKeys) {
                SocketChannel socketChannel;

                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel acceptableServerSocketChannel = (ServerSocketChannel) selectionKey.channel();
                    try {
                        socketChannel = acceptableServerSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                        registered.put(socketChannel, "[" + UUID.randomUUID().toString() + "]");
                        System.out.println("客户端连接");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
//                    selectionKeys.remove(selectionKey);
                } else if (selectionKey.isReadable()) {
                    socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer readBuffer = ByteBuffer.allocate(512);
                    String uuid = registered.get(socketChannel);
                    try {
                        readBuffer.clear();
                        int read = socketChannel.read(readBuffer);
                        if (read > 0) {
                            readBuffer.flip();
                            String readMessage = String.valueOf(Charset.forName("utf-8").decode(readBuffer).array());
                            System.out.println(socketChannel + ":" + readMessage);

                            for (Map.Entry<SocketChannel, String> entry : registered.entrySet()) {
                                ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                                writeBuffer.put((uuid + ":" + readMessage + "\r\n").getBytes());
                                writeBuffer.flip();
                                entry.getKey().write(writeBuffer);
                            }

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            selectionKeys.clear();

        }
    }
}
