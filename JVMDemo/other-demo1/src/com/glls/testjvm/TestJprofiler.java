package com.glls.testjvm;

import java.util.ArrayList;

/**
 * @ClassName : TestJprofiler
 * @Author : glls
 * @Date: 2021/10/13 0:14
 * @Description :    通过  jprofiler 分析  内存  dump 文件
 */
public class TestJprofiler {

    byte[] arr = new byte[1024*1024];

    public static void main(String[] args) {
        ArrayList<TestJprofiler> list = new ArrayList<>();
        int count = 0;
        try {
            while(true){
                list.add(new TestJprofiler());
                count=count+1;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
