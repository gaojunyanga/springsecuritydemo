package com.glls.testjvm;


import java.io.IOException;

/**
 * @ClassName : HeapStudy
 * @Author : glls
 * @Date: 2021/10/12 20:23
 * @Description :
 *
 * 堆内存：
 *  新生代
 *      eden 伊甸园区
 *      from  幸存者1区
 *      to     幸存者2区
 *  老年代
 *
 *
 *
 *
 *
 *  // -Xms1024m -Xmx1024m -XX:+PrintGCDetails        打印GC垃圾回收信息
 *  // -Xms1024m -Xmx1024m -XX:+HeapDumpOnOutOfMemoryError    //  oom  dum
 */
public class RuntimeStudy {


    public static void main(String[] args) {
        System.out.println("测试打印内存信息");

        //返回虚拟西试图使用的最大内存
        long max = Runtime.getRuntime().maxMemory();

        //返回jvm的初始化总内存
        long total = Runtime.getRuntime().totalMemory();


        System.out.println("max="+max+"字节"+(max/(double)1024/1024)+ "mb");  //默认分配的总内存为电脑内存的1/4
        System.out.println("total="+total+"字节"+(total/(double)1024/1024)+ "mb"); //默认分配的初始化内存为电脑内存的1/64


        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
