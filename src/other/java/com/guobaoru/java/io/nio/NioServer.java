package com.guobaoru.java.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Created by guobaoru.
 * @create on 2018/8/30.
 */
public class NioServer {
    public static void main(String[] args) throws IOException {

        // 创建一个serverSockerChannel 获取一个channel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();  // @return  A new socket channel

        // 创建一个 ip 为本地，端口为 8081 的 LocalAddress
        InetSocketAddress port = new InetSocketAddress(8081);

        // channel 绑定监听
        serverSocketChannel.bind(port);

        // channel 设置为非阻塞
        serverSocketChannel.configureBlocking(false);

        // 创建一个 Selector
        Selector selector = Selector.open();

        /**
         * 5.注册事件类型  -  待熟知
         *
         *  sel:通道选择器
         *  ops:事件类型 ==>SelectionKey:包装类，包含事件类型和通道本身。四个常量类型表示四种事件类型
         *  SelectionKey.OP_ACCEPT 获取报文      SelectionKey.OP_CONNECT 连接
         *  SelectionKey.OP_READ 读           SelectionKey.OP_WRITE 写
         */
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            System.out.println("服务器端：正在监听8081端口");
            // 6.获取可用I/O通道,获得有多少可用的通道
            int num = selector.select();
            if (num > 0) { // 判断是否存在可用的通道
                // 获得所有的keys
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                // 使用iterator遍历所有的keys
                Iterator<SelectionKey> iterator = selectedKeys.iterator();
                // 迭代遍历当前I/O通道
                while (iterator.hasNext()) {
                    // 获得当前key
                    SelectionKey key = iterator.next();
                    // 调用iterator的remove()方法，并不是移除当前I/O通道，标识当前I/O通道已经处理。
                    iterator.remove();
                    // 判断事件类型，做对应的处理
                    if (key.isAcceptable()) {
                        ServerSocketChannel ssChannel = (ServerSocketChannel) key.channel();
                        SocketChannel socketChannel = ssChannel.accept();

                        System.out.println("处理请求："+ socketChannel.getRemoteAddress());

                        // 获取客户端的数据
                        // 设置非阻塞状态
                        socketChannel.configureBlocking(false);
                        // 注册到selector(通道选择器)
                        socketChannel.register(selector, SelectionKey.OP_READ);

                    } else if (key.isReadable()) {

                        //调用读操作工具类
                        RequestProcessor.ProcessorRequest(key,selector);

                    } else if (key.isWritable()) {

                        //调用写操作工具类
                        ResponeProcessor.ProcessorRespone(key);
                    }
                }
            }
        }


    }
}
