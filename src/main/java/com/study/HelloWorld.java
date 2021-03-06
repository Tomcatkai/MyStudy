package com.study;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.concurrent.CountDownLatch;

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

    /**
     * 分隔以逗号隔开的字符串为数组
     */
    @Test
    void test6(){
        String str = "a,b,c,d,e,f,g,h,i,j";
        String[] arr = str.split(",");
        System.out.println(arr);
    }

    /**
     * try中return,finally中修改值,看返回结果
     */
    @Test
    void test8(){
        System.out.println(test7());
    }
    int test7(){
        int i = 3;
        try {
            return i;
        }finally {
            ++i;
        }
    }

    /**
     * 继承Thread类实现多线程
     */
    @Test
    void test9(){
       MyThread myThread = new MyThread();
       myThread.start();
        while (true){
            System.out.println("外层死循环执行中!");
        }
    }
    class MyThread extends Thread{
        @Override
        public void run() {
            while (true){
                System.out.println("MyThread 正在运行");
            }
        }
    }

    /**
     * 实现Runnable接口实现多线程
     */
    @Test
    void test10(){
        MyThread2 myThread2 = new MyThread2();
        Thread thread = new Thread(myThread2);
        thread.start();
        int j = 0;
        while (j<1000){
            System.out.println("原方法正在运行");
            j++;
        }

    }
    class MyThread2 implements Runnable{
        @Override
        public void run() {
            int i = 0;
            while (i<1000){
                System.out.println("MyThread 正在运行");
                i++;
            }
        }
    }

    /**
     * 使用继承Thread类方式实现卖票,可发现,各个进程都卖出了100张票,各个进程之间并没有共享资源
     */
    @Test
    void test11(){
        TicketWindow ticketWindow1 = new TicketWindow();
        TicketWindow ticketWindow2 = new TicketWindow();
        TicketWindow ticketWindow3 = new TicketWindow();
        TicketWindow ticketWindow4 = new TicketWindow();
        ticketWindow1.start();
        ticketWindow2.start();
        ticketWindow3.start();
        ticketWindow4.start();

    }
    class TicketWindow extends Thread{
        private int ticketNum = 100;
        @Override
        public void run(){
            while (true){
                if(ticketNum>0){
                    Thread thread = Thread.currentThread();
                    String thName = thread.getName();
                    System.out.println(thName+"正在发售第"+ticketNum--+"张票");
                }
            }
        }
    }

    /**
     * 采用实现Runnable接口的方式实现卖票
     */
    @Test
    void test12() throws InterruptedException {
        TicketWindow2 ticketWindow2 = new TicketWindow2();
        Thread thread1 = new Thread(ticketWindow2);
        thread1.setDaemon(false);
        thread1.start();
        Thread thread2 = new Thread(ticketWindow2);
        thread2.setDaemon(false);
        thread2.start();
        Thread thread3 = new Thread(ticketWindow2);
        thread3.setDaemon(false);
        thread3.start();
        Thread thread4 = new Thread(ticketWindow2);
//        thread4.setDaemon(false);
        thread4.start();
        Thread.sleep(20000);
    }
    class TicketWindow2 implements Runnable{
        private int ticket = 1000;
        final Object lock = new Object();
        @Override
        public void run(){
            synchronized (lock) {
                while (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("hello");
                    }
                    System.out.println(Thread.currentThread().getName() + "正在发售第" + ticket-- + "张票");
                }
            }
        }
    }


    /**
     * 演示当一个程序只有后台线程时,该程序会终止运行
     */
    @Test
    void test13(){
        System.out.println("main 线程是后台线程吗?"+Thread.currentThread().isDaemon());
        DamonThread damonThread = new DamonThread();
        Thread thread = new Thread(damonThread,"后台线程");
        System.out.println("t线程默认是后台线程吗?"+thread.isDaemon());
        thread.setDaemon(true);
        System.out.println("t线程设置后的状态"+thread.isDaemon());
        thread.start();
        for (int i = 0;i<10;i++){
            System.out.println(i);
        }
    }

    class DamonThread implements Runnable{
//        private int forNum = 1000;
        @Override
        public void run(){
           while (true){
               System.out.println(Thread.currentThread().getName()+"----is running");
           }
        }
    }

    class MaxPriority implements Runnable{
        @Override
        public void run(){
            for (int i = 0;i<10;i++){
                System.out.println(Thread.currentThread().getName()+"正在输出:"+i);
            }
        }
    }
    class MinPriority implements Runnable{
        @Override
        public void run(){
            for (int i = 0;i<10;i++){
                System.out.println(Thread.currentThread().getName()+"正在输出:"+i);
            }
        }
    }

    /**
     * 测试线程优先级
     */
    @Test
    void test14(){
        MaxPriority maxPriority = new MaxPriority();
        MinPriority minPriority = new MinPriority();
        Thread maxThread = new Thread(maxPriority,"高优先级线程");
        Thread minThread = new Thread(minPriority,"低优先级线程");
        maxThread.setPriority(Thread.MAX_PRIORITY);
        minThread.setPriority(Thread.MIN_PRIORITY);
        maxThread.start();
        minThread.start();
    }

    /**
     * 测试线程休眠
     * @throws InterruptedException
     */
    @Test
    void test15() throws InterruptedException {
        new Thread(new SleepThread()).start();
        for(int i=1;i<=10;i++){
            if(i==5){
                Thread.sleep(2000);
            }
            System.out.println("主线程正在输出:"+i);
            Thread.sleep(500);
        }
    }

    class SleepThread implements Runnable{
        @Override
        public void run() {
            for (int i=1;i<=10;i++){
                if(i==3){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程一正在输出:"+i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class YieldThread extends Thread{
        public YieldThread(String name){
            super(name);
        }

        @Override
        public void run() {
            for(int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+"---"+i);
                if(i==3){
                    System.out.println("线程让步:");
                    Thread.yield();//线程运行到此做出让步
                }
            }
        }
    }

    /**
     * 测试线程让步
     */
    @Test
    void test16(){
        YieldThread yieldThread1 = new YieldThread("线程A");
        YieldThread yieldThread2 = new YieldThread("线程B");
        yieldThread1.start();
        yieldThread2.start();
    }

    class EmergencyThread implements Runnable{
        @Override
        public void run() {
            //每次循环休眠500ms 循环5次
            for(int i = 1;i<6;i++){
                System.out.println(Thread.currentThread().getName()+"输入:"+i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    /**
     * 测试线程插队的join方法
     */
    @Test
    void test17(){
        //创建线程后循环5次每次休眠500ms 当循环到第二次时,调用之前线程的join方法
        Thread thread = new Thread(new EmergencyThread(),"线程一");
        thread.start();
        //每次循环休眠500ms 循环5次
        for(int i = 1;i<6;i++){
            System.out.println(Thread.currentThread().getName()+"输入:"+i);
            if(i==2){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 测试同步方法
     */
    @Test
    void test18() throws InterruptedException {
        Ticket ticket = new Ticket();
        CountDownLatch countDownLatch = ticket.countDownLatch;
        new Thread(ticket,"线程一").start();
        new Thread(ticket,"线程二").start();
        new Thread(ticket,"线程三").start();
        new Thread(ticket,"线程四").start();
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"执行完毕");
    }

    class Ticket implements Runnable{
        private int tickets = 10;
        private  CountDownLatch countDownLatch = new CountDownLatch(10);
        @Override
        public void run() {
            while (true){
                //调用售票方法
                saleTicket();
                if(tickets<0){
                    break;
                }
            }
        }

        /**
         * 售票同步方法  每卖一张票休眠10ms
         */
        private synchronized void saleTicket(){
            if(tickets>0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"---卖出的票"+tickets--);
            }
        }
    }


    void testme(){
        int a[] = {};
    }
}
