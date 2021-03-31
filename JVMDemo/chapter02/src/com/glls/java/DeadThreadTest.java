package com.glls.java;

/**
 * @ClassName : DeadThreadTest
 * @Author : glls
 * @Date: 2021/3/30 21:50
 * @Description :
 * 虚拟机必须保证一个类的`<clinit>()`方法在多线程下被同步加锁
 */
public class DeadThreadTest {
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + "开始");
            DeadThread dead = new DeadThread();
            System.out.println(Thread.currentThread().getName() + "结束");
        };

        Thread t1 = new Thread(r,"线程1");
        Thread t2 = new Thread(r,"线程2");

        t1.start();
        t2.start();
    }
}


class DeadThread{
    static{
        if(true){
            System.out.println(Thread.currentThread().getName() + "初始化当前类");
            while(true){

            }
        }
    }
}