package basejava.io.file_rw_demo;

import org.junit.platform.commons.util.StringUtils;

import java.io.*;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class NginxCount3 {
    private static final String CSV_RN = "\r\n";

    public static void main(String[] args) throws IOException {

        StringBuilder sbd = new StringBuilder();
        HashMap infoMap = new HashMap();
        HashMap<String, List<String>> pMap = new HashMap();
        HashMap<String, List<String>> urlMap = new HashMap();

        /**
         * 读取权限
         */
        try (Stream<String> lines = Files.lines(Paths.get("D:\\user2.csv"), Charset.forName("GBK"))) {
            lines.forEach(line -> {
                String[] strs = line.split(",");
                infoMap.put(strs[0], strs[2]);
                if (pMap.get(strs[0]) == null) {
                    List list = new ArrayList();
                    list.add(strs[3]);
                    pMap.put(strs[0], list);
                } else {
                    List list = pMap.get(strs[0]);
                    list.add(strs[3]);
                    pMap.put(strs[0], list);
                }

            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        OutputStream stream = new FileOutputStream("D:\\count\\CC系统多权限访问_20190308_02.txt");
        OutputStreamWriter osw = new OutputStreamWriter(stream, "GBK");
        BufferedWriter writer = new BufferedWriter(osw);


        /**
         * 读取日志
         */
        try (Stream<String> lines = Files.lines(Paths.get("D:\\data08_02.log"), Charset.forName("GBK"))) {
            lines.forEach(line1 -> {
                String[] accessLog = line1.split(" ");
                String tmpCCID = "";
                try {
                    tmpCCID = Arrays.asList(accessLog).stream().filter(e -> e.contains("autologin")).findAny().get();
                    tmpCCID = URLDecoder.decode(tmpCCID, "UTF-8");
                } catch (Exception e) {
                }

                String[] str3 = tmpCCID.split("\\;");
                if (str3.length < 2) {
                    return;
                }
                String[] str4 = str3[1].split("\"");

                String userId = str4[1];

                if (StringUtils.isBlank(userId)) {
                    System.out.println("userID为空：" + line1);
                }

                if (pMap.get(userId) == null) {
                    System.out.println("未知userID：" + userId);
                    return;
                }
                if (pMap.get(userId).size() > 3) {
                    write(line1, userId, infoMap, pMap, urlMap, sbd);
                    return;
                }
                List temp = new ArrayList();
                temp.addAll(pMap.get(userId));
                if (temp.contains("7")) {
                    temp.remove("7");
                }
                if (temp.contains("8")) {
                    temp.remove("8");
                }
                if (temp.contains("64")) {
                    temp.remove("64");
                }

                if (temp.size() > 0) {
                    write(line1, userId, infoMap, pMap, urlMap, sbd);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        writer.write(sbd.toString());
        writer.flush();
    }


    /**
     * 写出统计数据
     *
     * @param line
     * @param userId
     * @param infoMap
     * @param pMap
     * @param urlMap
     * @param sbd
     */
    private static void write(String line, String userId, HashMap infoMap, HashMap pMap, HashMap urlMap, StringBuilder sbd) {
        String[] url = line.split(" ");
        String[] tmpUrl = url[5].split("\\=|\\&");
        if (tmpUrl.length < 4) {
            return;
        }
        String acccessUrl = "c=" + tmpUrl[1] + "&m=" + tmpUrl[3];
        String info = "userId:" + userId + ";  name:" + infoMap.get(userId) + ";  role_ids:" + pMap.get(userId).toString() + ";  url:" + acccessUrl;
        // 判断url 是否已经写入过
        if (urlMap.get(acccessUrl) == null) {
            List list = new ArrayList();
            list.add(userId);
            urlMap.put(acccessUrl, list);
            sbd.append(info + CSV_RN);
            System.out.println(info);
        } else {
            Object o = urlMap.get(acccessUrl);
            List list = new ArrayList();
            if (o != null) {
                list = (List) o;
            }

            if (!list.contains(userId)) {
                list.add(userId);
                urlMap.put(acccessUrl, list);
                sbd.append(info + CSV_RN);
                System.out.println(info);
            }
        }
    }

}
