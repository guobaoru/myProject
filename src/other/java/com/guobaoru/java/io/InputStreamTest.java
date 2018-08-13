package com.guobaoru.java.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by guobaoru.
 * @create on 2018/7/30.
 */
public class InputStreamTest {

    public static void main(String[] args) {

        try {

            File file = new File("D:\\test1.csv");
            byte[] a = new byte[]{};

            // InputStream - 基本类，可创建其子类的实现
            InputStream inputStream = new FileInputStream(file);
            InputStream inputStream2 = new ByteArrayInputStream(a);

            // 子类，还有等等...
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a);
            FileInputStream fileInputStream = new FileInputStream(file);

            // BufferedInputStream 是 FileInputStream 的子类，但却可以创建各子类的缓冲流
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(byteArrayInputStream);
            BufferedInputStream bufferedInputStream3 = new BufferedInputStream(fileInputStream);

            // 字符流，联通字节流的桥梁，可以通过字节流包括其他子类进行创建
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"GBK");
            InputStreamReader inputStreamReader2 = new InputStreamReader(fileInputStream,"GBK");
            InputStreamReader inputStreamReader3 = new InputStreamReader(byteArrayInputStream,"GBK");
            InputStreamReader inputStreamReader4 = new InputStreamReader(bufferedInputStream,"GBK");

            // 字符流，可直接读取file的字节流
            FileReader fileReader = new FileReader("D:\\test1.csv");

            // FileReader 继承 InputStreamReader   InputStreamReader 继承 Reader
            InputStreamReader inputStreamReader5 = new FileReader("D:\\test1.csv");

            // Reader 字符流的基本类
            Reader reader = new FileReader("D:\\test1.csv");

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            BufferedReader bufferedReader2 = new BufferedReader(fileReader);

            bufferedReader.readLine();

            String line;
            List<String> lines = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }

            System.out.println(lines.toString());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
