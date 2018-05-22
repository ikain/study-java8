package com.kai;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by FengKai on 2018/5/7.
 */
public class Main22 {

    public static void main(String[] args) {
        getCdnByte("CDNKEY8c5b5c33f5f94233ab34d84d89e1f7d3.mp3");
    }


    public static byte[] getCdnByte(String filePath) {
        String cdnVisitPath = "http://zhixueyuncdn.zhixueyun.com";
        InputStream in = null;
        byte[] bytes = null;
        try {
            filePath = cdnVisitPath + "/" + filePath;
            URL url = new URL(filePath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
            connection.setRequestProperty("Referer", "http://.zhixueyun.com/");
            in = connection.getInputStream();
            bytes = InputStreamTOByte(in);
            //文件保存位置
            File file = new File("D:\\WorkSpace10\\study\\study-all\\ProjectJDK8\\kk.mp3");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bytes);
            fos.close();
            in.close();
        } catch (MalformedURLException e) {
            System.out.println(filePath + " 文件地址没有找到！");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(filePath + " 文件流获取失败!");
            e.printStackTrace();
        }
        return bytes;
    }

    private static byte[] InputStreamTOByte(InputStream in) throws IOException {
        int buffer_size = 4096;
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();

        byte[] data = new byte[buffer_size];

        int count;

        while ((count = in.read(data, 0, buffer_size)) != -1)

            outStream.write(data, 0, count);

        return outStream.toByteArray();

    }
}
