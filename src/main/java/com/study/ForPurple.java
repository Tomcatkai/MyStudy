package com.study;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.*;

/**
 * 面试题
 *
 * @author kaizhang
 * @create 2018-07-13 18:28
 **/

class ForPurple {
    static void main(String[] args) {
       assert true;
        System.out.println("断言1没有问题");
        System.out.println("--------------");
        assert false:"断言失败,输出异常信息";
        System.out.println("断言2没有问题");
    }

    @Test
    void test1() throws IOException {
        InetAddress localAddress = InetAddress.getLocalHost();
        InetAddress remoteAddress = InetAddress.getByName("www.itcast.cn");
        System.out.println("本机的IP地址;"+localAddress.getHostAddress());
        System.out.println("itcast的IP地址:"+remoteAddress.getHostAddress());
        System.out.println("3秒是否可达:"+remoteAddress.isReachable(3000));
        System.out.println("itcast的主机名为"+remoteAddress.getHostName());
    }
    @Test
    void test2() throws IOException {
        byte[] buf = new byte[1024];
        DatagramSocket ds = new DatagramSocket(8954);
        DatagramPacket dp = new DatagramPacket(buf,1024);
        System.out.println("等待接收数据");
        //等待接收数据,如果没有数据则会阻塞
        ds.receive(dp);
        String str = new String(dp.getData(),0,dp.getLength())+"from"+dp.getAddress().getHostAddress()+":"+dp.getPort();
        System.out.println(str);
        ds.close();
    }

    @Test
    void test3() throws IOException {
    DatagramSocket ds = new DatagramSocket(3000);
    String str = "hello world";

    DatagramPacket dp = new DatagramPacket(str.getBytes(),str.length(),InetAddress.getByName("localhost"),8954);
        System.out.println("发送信息");
        ds.send(dp);
        ds.close();
    }

    @Test
    void test4(){
        System.out.println(ForPurple.parseInt("123",7));
    }

    static int parseInt(String str4, int radix) {
        /* 异常情况1：字符串为null */
        if (str4 == null) {
            throw new IllegalArgumentException("字符串为null!");
        }
        int length = str4.length(), offset = 0;
        /* 异常情况2：字符串长度为0 */
        if (length == 0) {
            throw new IllegalArgumentException("字符串长度为0！");
        }
        boolean negative = str4.charAt(offset) == '-';
        if (negative) {
            throw new IllegalArgumentException("字符串位负数！");
        }
        int result = 0;
        char[] temp = str4.toCharArray();
        while (offset < length) {
            char digit = temp[offset++];
            int currentDigit = digit - '0';
            /* 一位一位判断，是否在0~7之间，否则为非法输入 */
            if (currentDigit < radix && currentDigit >= 0) {
                /* 2种溢出情况，第1种，当前的resut已经等于Integer.MAX_VALUE / 10，看个位数是否在范围内 */
                if (result == Integer.MAX_VALUE / radix
                        && currentDigit > Integer.MAX_VALUE % radix) {
                    throw new IllegalArgumentException("字符串溢出！");
                    /* 2种溢出情况，第2种，当前的resut已经大于Integer.MAX_VALUE / 10，不论个位是什么，都溢出 */
                } else if (result > Integer.MAX_VALUE / radix) {
                    throw new IllegalArgumentException("字符串溢出！");
                }
                /*关键部分*/
                result = result * radix + currentDigit;
            } else {
                throw new IllegalArgumentException("字符串字符不在0~"+radix+"!");
            }

        }
        return result;
    }


    }
