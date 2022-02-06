package com.glls.java1;

/**
 * @ClassName : ClassLoaderTest
 * @Author : glls
 * @Date: 2021/3/31 21:39
 * @Description :
 *   引导类加载器  是 c/c++ 写的
 *   扩展类加载器  是 java实现的
 *   系统（应用）类加载器  是 java 实现的
 *
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        // 获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取其上层： 扩展类加载器

        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);


        // 扩展类加载器 获取其上层 时   获取不到 引导类加载器
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);  // null



        //对于用户自定义类来说    默认使用系统类加载器来加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();

        System.out.println(classLoader);


        //String 类是由谁加载的  ?  是由 引导类加载器加载的    java 的核心类库都是由 引导类加载器加载的
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);   // null

    }
}
