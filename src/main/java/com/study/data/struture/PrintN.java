package com.study.data.struture;

import org.junit.jupiter.api.Test;

/**
 * 传入一个正整数N后,能顺序打印从1到N的全部正整数
 *
 * @author kaizhang
 * @create 2018-07-17 21:23
 **/

public class PrintN {

    public static void main(String[] args) {
        PrintN printN = new PrintN();
        printN.test2(100000);
    }

    @Test
    void test1(){
        int n = 100000;
        for (int i = 1;i<n;i++){
            System.out.println(i);
        }
    }
     void test2(int n){
        if(n>0){
            n--;
            System.out.println(n);
            this.test2(n);
        }
    }

    @Test
    void test3(){
        test2(100000);
    }
}
