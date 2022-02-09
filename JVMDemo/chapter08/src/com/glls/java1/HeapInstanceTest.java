package com.glls.java1;

import java.util.ArrayList;
import java.util.Random;

/**
 * @ClassName : HeapInstanceTest
 * @Author : glls
 * @Date: 2022/2/6 22:42
 * @Description : 2
 *
 * -Xms600m -Xmx600m
 */
public class HeapInstanceTest {

    byte[] buffer = new byte[new Random().nextInt(1024 * 200)];

    public static void main(String[] args) {
        ArrayList<HeapInstanceTest> list = new ArrayList<>();
        while (true){
            list.add(new HeapInstanceTest());

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
