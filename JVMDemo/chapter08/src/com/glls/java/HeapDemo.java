package com.glls.java;

/**
 * @ClassName : HeapDemo
 * @Author : glls
 * @Date: 2022/2/5 21:30
 * @Description :1
 * -Xms10m -Xmx10m
 * 初始堆空间     最大堆空间
 */
public class HeapDemo {
    public static void main(String[] args) {
        System.out.println("start....");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end....");
    }
}
