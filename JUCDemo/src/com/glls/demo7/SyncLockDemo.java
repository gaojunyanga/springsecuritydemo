package com.glls.demo7;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName : SyncLockDemo
 * @Author : glls
 * @Date: 2021/7/19 20:27
 * @Description :   synchronized 是可重入锁
 */
public class SyncLockDemo {

    public static void main(String[] args) {
        //testSynchronized();    synchronized 可重入锁演示

        testLock();   //演示 Lock 可重入锁效果
    }

    private static void testLock() {
        Lock lock = new ReentrantLock();
        new Thread(()->{
            //上锁
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"外层");
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName()+"内层层");

                }catch (Exception e){

                }finally {
                    lock.unlock();
                }

            }catch (Exception e){

            }finally {
                lock.unlock();
            }
        }).start();
    }

    private static void testSynchronized() {
        Object o = new Object();
        new Thread(()->{
            synchronized (o){
                System.out.println(Thread.currentThread().getName()+"外层");
                synchronized (o){
                    System.out.println(Thread.currentThread().getName()+"中层");
                    synchronized (o){
                        System.out.println(Thread.currentThread().getName()+"内层");

                    }
                }
            }
        }).start();
    }

}
