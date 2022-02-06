package com.glls.stack.java;

/**
 * @ClassName : StackErrorTest
 * @Author : glls
 * @Date: 2021/4/7 19:18
 * @Description : 2  栈溢出异常  StackOverflowError
 *
 * 默认情况下 ：count 的值  是  11420 次左右
 *
 * 设置栈的大小  ：  -Xss256k    count值是 2475 次左右
 *
 */
public class StackErrorTest {
    private static  int count = 1;
    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);    // 无限递归调用   导致 栈溢出
    }
}
