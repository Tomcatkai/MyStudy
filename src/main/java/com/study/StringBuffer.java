package com.study;

/**
 * StringBuffer 方法演示
 *
 * @author kaizhang
 * @create 2018-06-23 11:02
 **/

public class StringBuffer {
    public static void main(String[] args) {
        System.out.println("1.添加---------------------");
        add();
        System.out.println("2.删除---------------------");
        delete();
        System.out.println("3.修改---------------------");
        alter();
    }

    public static void add(){
        //定义一个字符串缓冲区
        StringBuffer sb = new StringBuffer();
        //在末尾添加字符串
        //在指定位置插入字符串
    }

    public static void delete(){
        //指定范围删除
        //指定位置删除
        //清空缓冲区
    }
    public static void alter(){
        //修改指定位置字符
        //替换指定位置字符串或字符
        //字符串翻转
    }

}
