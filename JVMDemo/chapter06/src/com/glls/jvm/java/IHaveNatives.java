package com.glls.jvm.java;

/**
 * @ClassName : IHaveNatives
 * @Author : glls
 * @Date: 2022/2/5 17:01
 * @Description :    本地方法接口
 */
public class IHaveNatives {
    public native void Native1(int x);

    public native static long Native2();

    private native synchronized float Native3(Object o);

    native void Native4(int[] ary) throws Exception;
}
