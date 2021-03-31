package com.glls.java;

/**
 * @ClassName : ClassInitTest
 * @Author : glls
 * @Date: 2021/3/29 21:53
 * @Description :
 */
public class ClassInitTest {
    private static int num = 1;

    static {
          num =2;
         number = 5;
        //System.out.println(number);
    }

    private static int number = 10;

    public static void main(String[] args) {
        System.out.println(ClassInitTest.num);
        System.out.println(ClassInitTest.number);
    }
}
