package com.kai;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * Created by FengKai on 2018/7/27.
 */
public class Main25 {
    public static void main(String[] args) {
        StringBuilder temp = new StringBuilder();//获取fastdfs域名
        StringBuilder path = new StringBuilder("https://zwydemo.zhixueyun.com/");//获取fastdfs域名
        path.append("default/M00/00/04/ClFE3Fr5TEeANkK1AAnM9CVLyfI219.jpg");//获取相对路径,并且组装成路径
        BufferedImage imge = getPic("学员A", "中大院测试中大院DSSSSSSSSSSSSSSSSA@##$@$广泛的鬼画符恢复换个风格回复", "组织名称X", temp, path, "2018100010");
        warrpData(imge);
    }

    static int isCnorEn(char c) {
        if (c >= 0x0391 && c <= 0xFFE5) //中文字符
            return 1;
        if (c >= 0x0000 && c <= 0x00FF) { //英文字符
            return 2;
        }
        return 3;
    }

    private static BufferedImage getPic(String name, String clzName, String orgName, StringBuilder temp, StringBuilder path, String num) {

        String allStr = "您完成了“" + clzName + "”的班级培训,经审核。准予颁发班级结业证书！";
        char[] charsName = allStr.toCharArray();
        int maxLen = 900;
        int realLen = 0;
        int chineseSize = 0;
        int englishSize = 0;
        int otherSize = 0;
        for (char aCharsName : charsName) {
            if (realLen > maxLen)
                break;
            int type = isCnorEn(aCharsName);
            switch (type) {
                case 1:
                    chineseSize++;
                    realLen += 25;
                    continue;
                case 2:
                    englishSize++;
                    realLen += 14;
                    continue;
                case 3:
                    otherSize++;
                    realLen += 14;
            }
        }

        try {
            int fristX = 180 + 20;
            int fristY = 510 - 50;
            int rowSize = chineseSize + englishSize + otherSize;
            int headX = 150 + 20;
            int headY = 470 - 50;

            int floorX = 750 + 50;
            //File file =  ResourceUtils.getFile("file:simhei.ttf") ;
            //logger.info("文件：{},存在：{}" ,file.getAbsoluteFile(),file.exists() );
            InputStream stream = Main25.class.getClassLoader().getResourceAsStream("./com/kai/simhei.ttf");
            BufferedInputStream bis = new BufferedInputStream(stream);
            Font font = null;
            try {
                font = Font.createFont(Font.TRUETYPE_FONT, bis);
                font = font.deriveFont(25f);
            } catch (FontFormatException e) {
                e.printStackTrace();
            } finally {
                bis.close();
                stream.close();
            }


            //获取图片  //zdy.fastdfsUrl
            BufferedImage bi = ImageIO.read(new URL(path.toString()));
            Graphics2D g2 = (Graphics2D) bi.getGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setPaint(Color.BLACK);
            g2.setFont(font);
            temp.append(name).append(",（先生AA/女士NN）");
            g2.drawString(temp.toString(), headX, headY); //称谓
            temp.setLength(0);//清空
            temp.append("您完成了").append("“")
                    .append(clzName).append("”").append("的班级培训,经审核。准予颁发班级结业证书！");
            if (temp.length() % rowSize == 0) {
                int row = temp.length() / rowSize;
                for (int i = 1; i <= row; i++) {
                    g2.drawString(temp.substring((i - 1) * rowSize, (i - 1) * rowSize + rowSize), fristX, fristY);
                    fristY += 40;
                }
            } else {
                int row = temp.length() / rowSize + 1;
                for (int i = 1; i <= row; i++) {
                    if (i != row) {
                        g2.drawString(temp.substring((i - 1) * rowSize, (i - 1) * rowSize + rowSize), fristX, fristY);
                    } else {
                        g2.drawString(temp.substring((i - 1) * rowSize, temp.length() - 1), fristX, fristY);
                    }
                    fristY += 40;
                }
            }

            temp.setLength(0);
            temp.append("证书编码：");
            temp.append(num);
            g2.drawString(temp.toString(), headX, fristY);

            temp.setLength(0);//清空
            temp.append(orgName);
            g2.drawString(temp.toString(), floorX, fristY + 40);   //机构

            temp.setLength(0);//清空
            temp.append("2018-09-09"); //日期
            g2.drawString(temp.toString(), floorX, fristY + 80);
            return bi;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("读取模板失败，请检测图片来源是否有问题！" + path.toString());
            throw new RuntimeException(e.getMessage());
        }
    }

    private static void warrpData(BufferedImage imge) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = null;

        try {
            ImageIO.write(imge, "png", out);
            //in = new ByteArrayInputStream(out.toByteArray());
            //out.reset();
            //GZIPHelper.compress(in, out);
            write(out);
            //String data = org.apache.commons.codec.binary.Base64.encodeBase64String(out.toByteArray());
            //IOUtils.copy(in, new FileOutputStream("/usr/shart/font/"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                //in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void write(ByteArrayOutputStream baos) {

        OutputStream out = null;
        try {
            out = new FileOutputStream("D:\\WorkSpace10\\study\\study-all\\ProjectJDK8\\test.png");
            ByteArrayInputStream is = new ByteArrayInputStream(baos.toByteArray());
            byte[] buff = new byte[1024];
            int len = 0;
            while ((len = is.read(buff)) != -1) {
                out.write(buff, 0, len);
            }
            is.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
