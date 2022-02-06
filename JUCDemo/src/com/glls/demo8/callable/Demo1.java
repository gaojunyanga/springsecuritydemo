package com.glls.demo8.callable;

import java.util.concurrent.Callable;

/**
 * @ClassName : Demo1
 * @Author : glls
 * @Date: 2021/7/19 22:12
 * @Description :  比较 Runnable 和 Callable
 */
//实现Runnable
class MyThread1 implements Runnable{

    @Override
    public void run() {

    }
}
//实现Callable
class MyThread2 implements Callable{

    @Override
    public Object call() throws Exception {
        return null;
    }
}

public class Demo1 {

    public static void main(String[] args) {

    }
}
