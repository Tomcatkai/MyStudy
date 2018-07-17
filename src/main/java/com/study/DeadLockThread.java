package com.study;

import org.junit.jupiter.api.Test;

/**
 * 死锁测试
 *
 * @author kaizhang
 * @create 2018-06-22 7:47
 **/

public class DeadLockThread implements Runnable{
    static Object chopsticks = new Object();
    static Object knifeAndFork = new Object();
    private boolean flag;
    DeadLockThread(boolean flag){
        this.flag = flag;
    }



    @Override
    public void run() {
        if (flag){
            while (true){
                synchronized (chopsticks){//chopsticks锁对象上的同步代码块
                    System.out.println(Thread.currentThread().getName()+"---if----chopsticks");
                    synchronized (knifeAndFork){//knifeAndFork锁对象上的同步代码块
                        System.out.println(Thread.currentThread().getName()+"---if---knifeAndFork");
                    }
                }
            }
        }else {
            while (true){
                synchronized (knifeAndFork){
                    System.out.println(Thread.currentThread().getName()+"---else---knifeAndFork");
                    synchronized (chopsticks){
                        System.out.println(Thread.currentThread().getName()+"---else---chopsticks");
                    }
                }
            }
        }
    }
}
