package com.glls.java;

/**
 * @ClassName : ClinitTest
 * @Author : glls
 * @Date: 2021/3/30 21:06
 * @Description :
 */
public class ClinitTest {
    // 任何一个类 声明以后  内部至少存在一个 类的 构造器
    private int a = 1;
    private static int c =3;

    public ClinitTest(){
        a = 10;
        int d = 20;
    }
    public static void main(String[] args) {
        int b = 2;
    }
}
