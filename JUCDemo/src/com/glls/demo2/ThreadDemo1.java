package com.glls.demo2;

/**
 * @ClassName : ThreadDemo1
 * @Author : glls
 * @Date: 2021/7/11 11:15
 * @Description : synchronized 实现线程通信
 *
 *
 *
 */

//第一步 创建资源类 定义属性和操作方法

class Share{
    //初始值
    int number = 0;

    public synchronized  void incr() throws InterruptedException {
        //第二步 判断 干活 通知
        //if(number!=0){  // 判断number 值是否是0 如果不是0 等待
        //    this.wait();   //在哪里睡   在哪里醒  所以 wait 方法之前的判断 要写在 while循环里
        //}

        while(number!=0){  // 判断number 值是否是0 如果不是0 等待
            this.wait();   //在哪里睡   在哪里醒  所以 wait 方法之前的判断 要写在 while循环里
        }
        //干活  如果number 值是 0    就 + 1
        number++;

        System.out.println(Thread.currentThread().getName()+"::"+number);

        //通知 其他线程
        this.notifyAll();
    }

    public synchronized  void decr() throws InterruptedException {
        //判断
        //if(number!=1){
        //    this.wait();  //在哪里睡   在哪里醒  所以 wait 方法之前的判断 要写在 while循环里
        //}
        while(number!=1){  // 判断number 值是否是1 如果不是1 等待
            this.wait();   //在哪里睡   在哪里醒  所以 wait 方法之前的判断 要写在 while循环里
        }
        //干活
        number--;
        System.out.println(Thread.currentThread().getName()+"::"+number);
        //通知其他线程
        this.notifyAll();
    }
}


public class ThreadDemo1 {
    //第三步  创建 多个线程 调用资源类的操作方法

    public static void main(String[] args) {
        Share share = new Share();

        //创建线程
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
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();

        new Thread(()->{
            for(int i=0;i<10;i++){
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"CC").start();

        new Thread(()->{
            for(int i=0;i<10;i++){
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"DD").start();
    }
}
