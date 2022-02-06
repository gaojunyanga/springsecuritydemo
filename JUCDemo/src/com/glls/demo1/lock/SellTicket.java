package com.glls.demo1.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName : SellTicket
 * @Author : glls
 * @Date: 2021/7/10 16:03
 * @Description :   Lock  卖票案例
 */
//第一步  创建资源类 定义属性和操作方法



class Ticket{
    //票数量
    private  int number = 30;
    //创建可重入锁
    private final ReentrantLock lock = new ReentrantLock(true);

    //卖票方法
    public void sale(){
        //上锁

        lock.lock();
        try {
            if(number>0){
                System.out.println(Thread.currentThread().getName()+"卖出"+(number--)+"剩下："+number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
public class SellTicket {
    //第二步  创建多个线程 调用资源类的操作方法
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(()->{
            for(int i=0;i<40;i++){
                ticket.sale();
            }
        },"AA").start();
        new Thread(()->{
            for(int i=0;i<40;i++){
                ticket.sale();
            }
        },"BB").start();
        new Thread(()->{
            for(int i=0;i<40;i++){
                ticket.sale();
            }
        },"CC").start();

    }
}
