package com.glls.stack.java3;

/**
 * @ClassName : VirtualMethodTable
 * @Author : glls
 * @Date: 2022/2/4 21:41
 * @Description :   虚方发表
 * 1.  在面向对象的编程中，会很频繁的使用到动态分派，
 * 如果在每次动态分派的过程中都要重新在类的方法元数据中搜索合适的目标的话就可能影响到执行效率。
 * 因此，为了提高性能，JVM采用在类的方法区建立一个虚方法表（virtual method table）来实现，
 * 非虚方法不会出现在表中。使用索引表来代替查找。【上面动态分派的过程，我们可以看到如果子类找不到，还要从下往上找其父类，非常耗时】
 *
 * 2.  每个类中都有一个虚方法表，表中存放着各个方法的实际入口。
 *
 * 3.  虚方法表是什么时候被创建的呢？虚方法表会在类加载的链接阶段被创建并开始初始化，类的变量初始值准备完成之后，JVM会把该类的虚方法表也初始化完毕。

 说白了  虚方法表就是为了记录 虚方法的入口在哪里，在有方法重写的情况时，实际调用哪个方法，不用每一次都从子类往上找。
 */
public class VirtualMethodTable {

}

class Cat implements Friendly{


    public void eat(){

    }

    @Override
    public void sayHello() {

    }

    @Override
    public void sayGoodbye() {

    }

    @Override
    protected void finalize(){

    }
}

class Dog{
    public void sayHello(){

    }

    @Override
    public String toString(){
        return "Dog";
    }
}

class CockerSpaniel extends Dog implements Friendly{

    @Override
    public void sayHello(){
        super.sayHello();
    }


    @Override
    public void sayGoodbye() {

    }
}


interface Friendly{
    void sayHello();
    void sayGoodbye();
}