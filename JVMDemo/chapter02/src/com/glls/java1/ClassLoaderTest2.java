package com.glls.java1;

/**
 * @ClassName : ClassLoaderTest2
 * @Author : glls
 * @Date: 2021/4/1 16:01
 * @Description :
 */
public class ClassLoaderTest2 {

    public static void main(String[] args) {
        try {
            //1. 获取指定 class 的 classLoader    String 的 类加载器为 引导类加载器 不是java语言编写的   获取不到
            ClassLoader classLoader = Class.forName("java.lang.String").getClassLoader();
            System.out.println(classLoader);
            //2. 获取当前线程上下文的classLoader    是  AppClassLoader  又叫系统类加载器
            ClassLoader classLoader1 = Thread.currentThread().getContextClassLoader();
            System.out.println(classLoader1);

            //3. 获取系统类加载器  AppClassLoader 的 上级      是 ExtClassLoader
            ClassLoader classLoader2 = ClassLoader.getSystemClassLoader().getParent();
            System.out.println(classLoader2);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
