package com.glls.stack.java3;

import java.io.IOException;
import java.util.Date;

/**
 * @ClassName : ReturnAddressTest
 * @Author : glls
 * @Date: 2022/2/4 22:18
 * @Description :  方法返回地址
 *
 * 返回指令包含  ireturn (当返回值是boolean ,byte,char.short,int 类型时使用)，
 * lreturn ,freturn.dreturn 以及 areturn, 另外还有一个return 指令供声明为void的方法
 * 实例初始化方法，类和接口的初始化方法使用
 */
public class ReturnAddressTest {
    public boolean methodBoolean() {
        return false;
    }

    public byte methodByte() {
        return 0;
    }

    public short methodShort() {
        return 0;
    }

    public char methodChar() {
        return 'a';
    }

    public int methodInt() {
        return 0;
    }

    public long methodLong() {
        return 0L;
    }

    public float methodFloat() {
        return 0.0f;
    }

    public double methodDouble() {
        return 0.0;
    }

    public String methodString() {
        return null;
    }

    public Date methodDate() {
        return null;
    }

    public void methodVoid() {

    }

    static {
        int i = 10;
    }


    public void method1() throws IOException {

    }

    public void method2() {
        methodVoid();

        try {
            method1();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}