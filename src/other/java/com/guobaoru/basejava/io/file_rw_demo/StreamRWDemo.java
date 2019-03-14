package basejava.io.file_rw_demo;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamRWDemo {


    private static final String CSV_RN = "\r\n";

    public static void main(String[] args) throws IOException {

        StringBuilder sbd = new StringBuilder();

        /**
         * read
         * try() 小括号内可关闭资源（流等）可随try结束自动释放
         */
        try (Stream<String> lines = Files.lines(Paths.get("D:\\user1.csv"), Charset.forName("GBK"))) {
            lines.forEach(line -> {
                System.out.println(line);
                sbd.append(line + CSV_RN);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * write
         */
        Files.write(Paths.get("D:\\result.txt"), sbd.toString().getBytes("GBK"));

    }


}
