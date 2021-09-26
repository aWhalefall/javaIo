package day2;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * author =kuaidao@reworldgame.com
 * time=2021/9/26 10:35
 * 回退流
 */
public class PushBackInputstreamDemo {

    public static void main(String[] args) {
        back();
    }

    /**
     * 读取到指定字符，回退并输出
     */
    private static void back() {
        String str = "hello,world";
        PushbackInputStream pushInputStream = null;
        ByteArrayInputStream byteArrayInputStream = null;
        byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        pushInputStream = new PushbackInputStream(byteArrayInputStream);
        int temp = 0;
        try {
            while ((temp = pushInputStream.read()) != -1) {
                if (temp == ',') {
                    pushInputStream.unread(temp);
                    temp = pushInputStream.read();
                    System.out.print("(回退" + (char) temp + ") "); // 输出回退的字符
                } else {
                    System.out.print((char) temp); // 否则输出字符
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                byteArrayInputStream.close();
                pushInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
