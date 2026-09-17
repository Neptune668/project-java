package com.atguigu.test.day5;

import org.junit.Test;

import java.util.*;

public class ListSetMap {
    @Test
    public void testList() {
        //创建，获取长度，拿元素，遍历
        ArrayList<String> list = new ArrayList<>();
        list.add("Tom");
        list.add("Jerry");
        list.add("Tom");
        list.add("Kate");
        list.add("Bob");


        System.out.println(list.size());
//        System.out.println(list.get(0));
        //遍历
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        for (String s : list) {
            System.out.println(s);
        }
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
        list.forEach(s -> System.out.println(s));
    }
    @Test
    public void testSet() {
        //判断某个元素是否在集合中(比上面多的内容
        Set<String> set = new HashSet<>();
        set.add("Tom");
        set.add("Jerry");
        set.add("Tom");
        set.add("Kate");
        set.add("Bob");
        System.out.println(set.size());//去重
        System.out.println(set.contains("Tom"));
        System.out.println(set.contains("Tom1"));
        set.forEach(s -> System.out.println(s));
    }
    @Test
    public void testMap() {
        //遍历不同
        Map<String, Integer> map = new HashMap();
        map.put("Tom", 18);
        map.put("Jerry", 19);
        map.put("Tom", 20);
        map.put("Kate", 21);
        map.put("Bob", 22);
        System.out.println(map.size());
        System.out.println(map.get("Tom"));
        System.out.println(map.get("Tom1"));
        System.out.println("----------------");
//        map.forEach((k, v) -> System.out.println(k + ":" + v));

        for (String s : map.keySet()) {
            System.out.println(s + ":" + map.get(s));
        }
        System.out.println("----------------");
        for (Integer value : map.values()) {
            System.out.println(value);
        }
        System.out.println("----------------");
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            stringIntegerEntry.getKey();
            stringIntegerEntry.getValue();
            System.out.println(stringIntegerEntry.getKey() + ":" + stringIntegerEntry.getValue());
        }
    }

    @Test
    public void test01(){
        ArrayList<String> list = new ArrayList<>();
        list.add("Tom");
        list.add("Jerry");
        list.add("Tom");
        list.add("Kate");
        list.add("Bob");
        List<String> strings = list.subList(0, 2);
        System.out.println(strings.getClass().getName());
    }
}
