package com.study;

/**
 * @author kaizhang
 * @create 2018-06-22 8:06
 **/

public class testDeadLock {
        public static void main(String[] args) {
            DeadLockThread deadLockThread1 = new DeadLockThread(true);
            DeadLockThread deadLockThread2 = new DeadLockThread(false);
            new Thread(deadLockThread1,"Chinese").start();
            new Thread(deadLockThread2,"America").start();
        }
}
