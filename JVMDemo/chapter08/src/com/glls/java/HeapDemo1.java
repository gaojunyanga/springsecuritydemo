package com.glls.java;

/**
 * @ClassName : HeapDemo1
 * @Author : glls
 * @Date: 2022/2/5 21:30
 * @Description :2
 * -Xms20m -Xmx20m
 */
public class HeapDemo1 {
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
