package com.glls.java;

/**
 * @ClassName : SimpleHeap
 * @Author : glls
 * @Date: 2022/2/5 22:22
 * @Description : 3
 * -XX:+PrintGCDetails       打印  GC的细节信息   是程序执行完以后 打印
 */
public class SimpleHeap {
    private int id;//属性、成员变量

    public SimpleHeap(int id) {
        this.id = id;
    }

    public void show() {
        System.out.println("My ID is " + id);
    }
    public static void main(String[] args) {
        SimpleHeap sl = new SimpleHeap(1);
        SimpleHeap s2 = new SimpleHeap(2);

        int[] arr = new int[10];

        Object[] arr1 = new Object[10];
    }
}
