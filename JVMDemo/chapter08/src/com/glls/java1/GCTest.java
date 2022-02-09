package com.glls.java1;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : GCTest
 * @Author : glls
 * @Date: 2022/2/8 21:06
 * @Description :  GC 举例  与 日志分析
 *
 *测试MinorGC 、 MajorGC、FullGC
 *-Xms9m -Xmx9m -XX:+PrintGCDetails
 *
 */
public class GCTest {
    public static void main(String[] args) {
        int i = 0;
        try {
            List<String> list = new ArrayList<>();
            String a = "glls.com";   // 字符串常量池 实际上是存储在 堆空间的，以前是在方法区  现在改到了堆空间
            while (true) {
                list.add(a);
                a = a + a;
                i++;
            }
        } catch (Throwable t) {
            t.printStackTrace();
            System.out.println("遍历次数为：" + i);
        }
    }
}
