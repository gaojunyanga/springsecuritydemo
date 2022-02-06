package com.glls.stack.java1;

import java.util.Date;

/**
 * @ClassName : LocalVariablesTest
 * @Author : glls
 * @Date: 2021/4/13 21:19
 * @Description : 3
 */
public class LocalVariablesTest {
    static int num = 10;
    private int count = 0;
    public static void main(String[] args) {
        LocalVariablesTest test = new LocalVariablesTest();
        int num =10;
        test.test1();
    }

    public static void testStatic(){
        LocalVariablesTest test = new LocalVariablesTest();
        Date date = new Date();
        int count = 10;
        System.out.println(count);
        //因为this变量不存在于当前方法的局部变量表中！！
//        System.out.println(this.count);
    }
    public void test1(){
        Date date = new Date();

    }

    public String test2(Date dateP, String name2) {
        dateP = null;
        name2 = "glls";
        double weight = 130.5;//占据两个slot
        char gender = '男';
        return dateP + name2;
    }

    public void test3() {
        this.count++;
    }

    public void test4() {
        int a = 0;

        {
            int b = 0;
            b = a + 1;
        }
        //变量c使用之前已经销毁的变量b占据的slot的位置
        int c = a + 1;
    }


}
