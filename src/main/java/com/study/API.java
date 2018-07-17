package com.study;

import org.junit.jupiter.api.Test;

/**
 * java api学习
 *
 * @author kaizhang
 * @create 2018-06-23 8:40
 **/

public class API {

    /**
     * String类的初始化练习
     */
    @Test
    void test1(){
        String str1 = new String("hello world!");
        System.out.println(str1);
        char[] value = {'h','e','l','l','o'};
        String str2 = new String(value);
        System.out.println(str2);
        String str3 = new String();
        System.out.println(str3);
    }

    /**
     * 字符串的基本操作
     */
    @Test
    void test2(){
        String str = "abcdcdbacdacadb";
        //获取字符串长度
        System.out.println("字符串长度为:"+str.length());
        //获取字符串中的第一个字符
        System.out.println("第一个字符为:"+str.charAt(0));
        //字符"c"第一次出现的位置
        System.out.println("c第一次出现的位置为:"+str.indexOf("c"));
        //字符"c"最后一次出现的位置
        System.out.println("c最后一次出现的位置为:"+str.lastIndexOf("c"));
    }

    /**
     * 字符串的转换操作:
     * 1.转为字符数组 toCharArray()
     * 2.int转为String valueOf
     * 3.转为大写 toUpperCase
     */
    @Test
    void test3(){
        //定义str
        String str = "abcd";
        //将字符串转为字符数组
        char [] charArr = str.toCharArray();
//        for (int i = 0;i<str.length();i++){
//        }
        //将int值转换为String类型之后的结果
        System.out.println(String.valueOf(12));
        //将字符串转换成大写之后的结果
        System.out.println(str.toUpperCase());
    }

    /**
     * 字符串的替换和去除空格
     */
    @Test
    void test4(){
        String str = "hello world";
        System.out.println(str.replace("l","t"));
        System.out.println(str);

        String str1 = " i l o v e y o u ";
        System.out.println(str1);
        System.out.println(str1.trim());

        System.out.println(str1.replaceAll(" ",""));
        System.out.println(str1);
    }

    /**
     * 字符串的判断操作
     */
    @Test
    void test5(){
        String str = "String";
        String str1 = "Str";

        //判断是否以字符串Str开头
        System.out.println(str.startsWith(str1));
        //判断是否以字符串ng结尾
        System.out.println(str.endsWith("ng"));
        //判断是否包含字符串tri
        System.out.println(str.contains("tri"));
        //判断字符串是否为空
        System.out.println(str.isEmpty());
        //判断两个字符串是否相等
        System.out.println(str.equals(str1));
    }

    /**
     * 字符串的截取与分割
     */
    @Test
    void test6(){
       String str = "羽毛球-篮球-乒乓球";
       //从第五个字符截取到末尾的结果
        System.out.println(str.substring(4,str.length()));
        //从第五个字符截取到第六个字符的结果
        System.out.println(str.substring(4,6));
        //将字符串转换为字符串数组
        String[] arr = str.split("-");
        System.out.println(arr);
    }

    @Test
    void test7(){
        String str = "abcabcabc";
        System.out.println(str.charAt(8));
    }
}
