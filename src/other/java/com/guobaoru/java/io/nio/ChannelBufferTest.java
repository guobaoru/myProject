package com.guobaoru.java.io.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Created by guobaoru.
 * @create on 2018/8/2.
 */
public class ChannelBufferTest {

    public static void main(String[] args) {

        try {

            RandomAccessFile aFile = new RandomAccessFile("D://lala.txt", "rw");

//            File file = new File("D:\\data.txt");
//            FileOutputStream outputStream = new FileOutputStream(file);
//            FileChannel channel = outputStream.getChannel();
            FileChannel channel = aFile.getChannel();

            ByteBuffer buf = ByteBuffer.allocate(48);


//            String java = "hello world";
//            buf.put(java.getBytes());
//            System.out.println(buf);
//            buf.flip();
//            channel.write(buf);
//            channel.close();


            int bytesRead = channel.read(buf);
            while (bytesRead != -1) {
                System.out.println("Read " + bytesRead);
                buf.flip();
                while(buf.hasRemaining()){
                    System.out.print((char) buf.get());
                }
                buf.clear();
                bytesRead = channel.read(buf);
            }
            aFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
