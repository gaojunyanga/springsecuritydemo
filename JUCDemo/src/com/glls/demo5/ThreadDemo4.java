package com.glls.demo5;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @ClassName : ThreadDemo4
 * @Author : glls
 * @Date: 2021/7/12 23:16
 * @Description :  List集合  线程的  不安全演示
 */
public class ThreadDemo4 {
    public static void main(String[] args) {
        //testList();

        //testSet();

        //HashMap<String, String> map = new HashMap<>();
        Map<String, String> map = new ConcurrentHashMap<>();
        for(int i=0;i<30;i++){
            String key = String.valueOf(i);
            new Thread(()->{
                map.put(key,UUID.randomUUID().toString().substring(0,8));
                //从集合获取元素
                System.out.println(map);
            }).start();
        }
    }

    private static void testSet() {
        //Set<String> set = new HashSet();
        Set<String> set = new CopyOnWriteArraySet<>();

        for(int i=0;i<30;i++){
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                //从集合获取元素
                System.out.println(set);
            }).start();
        }
    }

    private static void testList() {
        //ArrayList<String> list = new ArrayList<>();
        //List<String> list = Collections.synchronizedList(list);
        //Vector<String> list = new Vector<>();
        List<String> list = new CopyOnWriteArrayList<>();
        for(int i=0;i<10;i++){
            new Thread(()->{
                //向集合添加元素
                list.add(UUID.randomUUID().toString().substring(0,8));
                //从集合获取元素
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
