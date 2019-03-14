package basejava.io.file_rw_demo;

import java.io.*;


public class BIORWDemo {

    private static final String CSV_RN = "\r\n";

    public static void main(String[] args) throws IOException {

        StringBuilder sbd = new StringBuilder();

        File file = new File("D:\\user1.csv");
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "GBK");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            sbd.append(line + CSV_RN);
        }

        OutputStream stream = new FileOutputStream("D:\\result.txt");
        OutputStreamWriter osw = new OutputStreamWriter(stream, "GBK");
        BufferedWriter writer = new BufferedWriter(osw);

        writer.write(sbd.toString());
        writer.flush();
        writer.close();
        bufferedReader.close();
    }
}
