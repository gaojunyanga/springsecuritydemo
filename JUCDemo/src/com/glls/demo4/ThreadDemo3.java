package com.glls.demo4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName : ThreadDemo3
 * @Author : glls
 * @Date: 2021/7/12 21:44
 * @Description : 线程间定制化通信
 */
class Share{
    Lock lock = new ReentrantLock();
    Condition con1 = lock.newCondition();
    Condition con2 = lock.newCondition();
    Condition con3 = lock.newCondition();
    int flag = 1;

    public void actionAA(){
        lock.lock();
        try{
            while (flag!=1){
                con1.await();
            }
            for(int i=0;i<5;i++){
                System.out.print("AA ");
            }
            flag=2;
            con2.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public void actionBB(){
        lock.lock();
        try{
            while (flag!=2){
                con2.await();
            }
            for(int i=0;i<10;i++){
                System.out.print("BB ");
            }
            flag=3;
            con3.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

    public void actionCC(){
        lock.lock();
        try{
            while (flag!=3){
                con3.await();
            }
            for(int i=0;i<15;i++){
                System.out.print("CC ");
            }
            flag=1;
            con1.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
}

public class ThreadDemo3 {
    public static void main(String[] args) {
        Share share = new Share();
        Thread aa = new Thread(() -> {
            for(int i=0;i<10;i++){
                share.actionAA();

            }
        }, "AA");

        Thread bb = new Thread(() -> {
            for(int i=0;i<10;i++) {
                share.actionBB();
            }
        }, "BB");

        Thread cc = new Thread(() -> {
            for(int i=0;i<10;i++) {
                share.actionCC();
                System.out.println("");
            }
        }, "CC");

        aa.start();
        bb.start();
        cc.start();




    }
}
