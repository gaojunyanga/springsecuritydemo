package com.glls.demo7;

/**
 * @ClassName : DeadLock
 * @Author : glls
 * @Date: 2021/7/19 20:47
 * @Description :  演示死锁
 *
 * 使用  jps 和  jstack 可以看到死锁
 */
public class DeadLock {

    static Object a = new Object();
    static Object b = new Object();
    public static void main(String[] args) {
        new Thread(()->{
            synchronized (a){
                System.out.println(Thread.currentThread().getName()+"");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (b){
                    System.out.println(Thread.currentThread().getName()+"");
                }

            }
        },"aa").start();


        new Thread(()->{
            synchronized (b){
                System.out.println(Thread.currentThread().getName()+"");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (a){
                    System.out.println(Thread.currentThread().getName()+"");
                }

            }
        },"bb").start();

    }
}
