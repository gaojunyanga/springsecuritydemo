package com.glls.demo3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName : ThreadDemo3
 * @Author : glls
 * @Date: 2021/7/12 20:58
 * @Description : Lock 实现线程通信
 */

//定义资源类
class Share{
    private  int number = 0;

    //创建Lock
    private Lock lock = new ReentrantLock();
    Condition con1 = lock.newCondition();
    //+1
    public void incr() throws InterruptedException {
        //上锁
        lock.lock();
        try {
            //判断
            while (number!=0){
                con1.await();  //等待
            }
            //干活
            number++;
            System.out.println(Thread.currentThread().getName()+"::"+number);
            //通知
            con1.signalAll();

        }catch (Exception e){

        }finally {
            lock.unlock();
        }

    }

    //-1
    public void decr(){
        //上锁
        lock.lock();
        try {
            //判断
            while (number!=1){
                con1.await();  //等待
            }
            //干活
            number--;
            System.out.println(Thread.currentThread().getName()+"::"+number);
            //通知
            con1.signalAll();

        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
}
public class ThreadDemo2 {
    public static void main(String[] args) {
        Share share = new Share();
        new Thread(()->{
            for(int i=0;i<10;i++){
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();


        new Thread(()->{
            for(int i=0;i<10;i++){
                share.decr();
            }
        },"BB").start();

        new Thread(()->{
            for(int i=0;i<10;i++){
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"CC").start();


        new Thread(()->{
            for(int i=0;i<10;i++){
                share.decr();
            }
        },"DD").start();
    }
}
