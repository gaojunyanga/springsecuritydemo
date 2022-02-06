package com.glls.stack.java1;

/**
 * @ClassName : DynamicLinkingTest
 * @Author : glls
 * @Date: 2022/2/4 11: 00
 * @Description : 6 动态链接
 */
public class DynamicLinkingTest {

    int num = 10;
    public void methodA(){
        System.out.println("methodA");
    }


    public void methodB(double b){
        System.out.println("methodB");
        methodA();

        num++;
    }
}
