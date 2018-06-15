package com.study;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

/**
 * HelloWorld
 *
 * @author kaizhang
 * @create 2018-06-12 17:25
 **/

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("HelloWorld!");
    }

    /**
     * 跳出多重循环 方式一:使用标号
     */
    @Test
    void test1(){
        ok:
        for (int i=1;i<10;i++){
            System.out.println("i 当前值为:"+i);
            for (int j=0;j<i;j++){
                System.out.println("j 当前值为:"+j);
                if (j==5){
                    break ok;
                }
            }
        }
        System.out.println("出了外循环");
    }

    /**
     * 跳出多重循环 方式二:使用内部循环控制外部循环条件
     */
    @Test
    void test2(){
        int arr[][] = {{1,2,3},{4,5,6,7},{9}};
        boolean found = false;
        for (int i =0;i<arr.length&!found;i++){
            for (int j = 0;j<arr[i].length;j++){
                if(arr[i][j]==9){
                    System.out.println("i="+i+"& j="+j);
                    found = true;
                    break;
                }
            }
        }
    }

    /**
     * switch(expr) 中 expr 的类型只能为byte char short int 及其包装类及enum,String   共十个
     * JDK5.0中增加了enum
     * JDK7.0中增加了String
     */
    @Test
    void test3(){
        int i = 1;
//        String i = "hello";
//        long i = 35L;
        switch(i) {
            case 1:
                System.out.println("这里是switch 里的case1");
                break;
            case 2:
                System.out.println("这里是switch 里的case2");
                break;
                default:
                    System.out.println("这里是switch 里的 default");
                    break;
        }
        System.out.println("这里是switch的地盘外面");
    }

    /**
     * 表达式类型自动提升
     */
    void test4(){
        short s1 = 1;
//        s1 = s1+1;   错误:表达式计算时自动将类型提升为int
        //+=是java语言规定的运算符,java编译器会对它进行特殊处理,因此可以正确编译
        s1+=1;
        //进行强转
        s1 = (short) (s1+1);
    }

    /**
     * char中可以存放汉字,且char占两个字节,char使用Unicode编码
     * ps 字节为最小单位,一个字节占8位
     */
    void test5(){
        char a = '汉';
    }

}
