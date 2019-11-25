package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Eric
 * @Title: NioClient
 * @date 2019/8/8 13:36
 * @Description: TODO
 */
public class NioClient {
    public static void main(String args[]) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        socketChannel.register(selector, SelectionKey.OP_CONNECT);

        socketChannel.connect(new InetSocketAddress("172.17.20.48", 8899));


        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            for (SelectionKey selectionKey : selectionKeys) {
                if (selectionKey.isConnectable()) {

                    SocketChannel clientChannel = (SocketChannel) selectionKey.channel();

                    if (clientChannel.isConnectionPending()) {
                        clientChannel.finishConnect();
                        ByteBuffer writeBuffer = ByteBuffer.allocate(512);
                        writeBuffer.put((LocalDateTime.now() + "连接成功").getBytes());
                        writeBuffer.flip();
                        clientChannel.write(writeBuffer);
                        ExecutorService executorService = Executors.newSingleThreadExecutor();
                        executorService.submit(() -> {
                            while (true) {
                                writeBuffer.clear();
                                InputStreamReader inputStream = new InputStreamReader(System.in);
                                BufferedReader bufferedReader = new BufferedReader(inputStream);
                                String line = bufferedReader.readLine();
                                writeBuffer.put(line.getBytes());
//                                writeBuffer.flip();

                                clientChannel.write(writeBuffer);
                            }
                        });
                    }
                    clientChannel.register(selector,SelectionKey.OP_READ);
                }

                if (selectionKey.isReadable()) {
                    SocketChannel readChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer readBuffer = ByteBuffer.allocate(512);
                    while (true) {
                        try {
                            int read = readChannel.read(readBuffer);
                            if (read <= 0) {
                                break;
                            }
                            readBuffer.flip();
                            String message = String.valueOf(Charset.forName("utf-8").decode(readBuffer).array());
                            System.out.println(message);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            selectionKeys.clear();
        }

    }
}
