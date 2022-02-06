package com.glls.java;

/**
 * @ClassName : HelloApp
 * @Author : glls
 * @Date: 2021/3/29 21:52
 * @Description :2
 *  代码：变量a在准备阶段会赋初始值，但不是1，而是0，在初始化阶段会被赋值为 1
 */
public class HelloApp {
    private static int a = 1;//prepare：a = 0 ---> initial : a = 1


    public static void main(String[] args) {
        System.out.println(a);
    }
}
