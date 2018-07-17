package com.study;

/**
 * 测试
 *
 * @author kaizhang
 * @create 2018-06-22 11:20
 **/

public class Test {
    private Object obj = new Object();
    public synchronized void a(){
        try {
            System.out.println(obj);
            this.wait();
            System.out.println("waiting");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test);
       test.a();
    }
}
