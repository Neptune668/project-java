package com.atguigu.java.day5;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Demo01_ListSetMap {

    @Test
    public void test01List() {
        // 1、创建 List 集合对象：没有去重的能力
        // 通常会通过附加泛型参数来约束集合中存放的数据类型
        List<String> nameList = new ArrayList<>();
        nameList.add("tom");
        nameList.add("jerry");
        nameList.add("tom");
        nameList.add("kate");
        nameList.add("bob");

        // 2、打印集合的长度
        System.out.println("集合的长度：" + nameList.size());

        // 3、根据索引下标从集合中获取数据
        System.out.println(nameList.get(0));
        System.out.println(nameList.get(1));
        System.out.println(nameList.get(2));

        // java.lang.IndexOutOfBoundsException: Index 2333 out of bounds for length 5
        // System.out.println(nameList.get(2333));

        // 4、遍历 List 集合：通常使用增强的 for 循环
        for (int i = 0; i < nameList.size(); i++) {
            System.out.println("在循环中读取元素：" + nameList.get(i));
        }
        System.out.println("--------------------");
        for (String name : nameList) {
            System.out.println("增强 For 循环：" + name);
        }
        System.out.println("--------------------");
        Iterator<String> iterator = nameList.iterator();
        while (iterator.hasNext()) {
            String nextValue = iterator.next();
            System.out.println("nextValue = " + nextValue);
        }
    }

    @Test
    public void test02Set() {
        // 1、创建 Set 集合的对象
        Set<String> nameSet = new HashSet<>();

        // 2、把数据存入 Set 集合————HashSet有去重的能力
        // 去重的能力要求必须正确编写 equals()、hashCode() 方法
        // 原则：equals() 方法返回 true 的情况，hashCode() 方法返回的值也必须相等
        nameSet.add("Pig");
        nameSet.add("Pig");
        nameSet.add("Monkey");
        nameSet.add("Monkey");
        nameSet.add("Tiger");
        nameSet.add("Tiger");
        nameSet.add("Rabbit");
        nameSet.add("Rabbit");
        nameSet.add("Dog");
        nameSet.add("Dog");

        // 3、打印集合的长度
        System.out.println("集合的长度：" + nameSet.size());

        // 4、Set 集合遍历
        // HashSet 集合内部没有保证元素顺序的机制，遍历打印的顺序不一定和存入的顺序一致
        // [1]增强的 for 循环
        for (String name : nameSet) {
            System.out.println("增强的 for 循环：" + name);
        }
        System.out.println("---------------");

        // [2]迭代器
        Iterator<String> iterator = nameSet.iterator();
        while (iterator.hasNext()) {
            System.out.println("迭代器遍历：" + iterator.next());
        }

        // 5、判断某个元素是否在集合中
        // 底层也是基于 equals()、hashCode() 方法来进行是否相等的判断
        String specialName = "peter";
        System.out.println(nameSet.contains(specialName));
    }

    @Test
    public void test02Map() {
        // 1、创建 Map 集合对象
        Map<String, Double> scoreMap = new HashMap<>();

        // 2、把元素存入集合对象：Map 集合对 Key 有去重的能力，同时也不保证存放的顺序
        scoreMap.put("小明", 100.00);

        // 相同的 key 存入 Map 会覆盖原来的值
        scoreMap.put("小明", 150.00);
        scoreMap.put("小红", 150.00);
        scoreMap.put("小军", 80.00);
        scoreMap.put("朋朋", 45.00);
        scoreMap.put("小强", 94.00);

        // 3、根据 key 取值
        Double 小军 = scoreMap.get("小军");
        System.out.println("小军的分数 = " + 小军);

        // 如果 key 在 Map 中不存在，则返回 null 值，不会抛异常
        Double 小黄 = scoreMap.get("小黄");
        System.out.println("小黄的分数 = " + 小黄);

        // 4、检查指定的 key 是否存在
        System.out.println("是否存在小黄的成绩：" + scoreMap.containsKey("小黄"));

        // 5、Map 集合的遍历
        // 基本思路：先转换成 Collection 集合再遍历
        // [1]获取 Map 集合中所有 key 组成的 Set 集合
        Set<String> scoreMapKeySet = scoreMap.keySet();
        for (String name : scoreMapKeySet) {
            Double score = scoreMap.get(name);
            System.out.println(name + " 得分是：" + score);
        }
        System.out.println("-----------------------");

        // [2]获取 Map 集合全部的 value 组成的 Collection 集合
        // Map 可以根据 key 取 value，不能根据 value 反过来去取 key
        Collection<Double> scoreMapValues = scoreMap.values();
        for (Double scoreMapValue : scoreMapValues) {
            System.out.println("scoreMapValue = " + scoreMapValue);
        }

        System.out.println("-----------------------");

        // [3]获取 Map 集合中所有 Entry 组成的 Set 集合
        // Entry 就是单独的一个键值对，里面只有一个键和一个值
        Set<Map.Entry<String, Double>> entries = scoreMap.entrySet();
        for (Map.Entry<String, Double> entry : entries) {
            String key = entry.getKey();
            Double value = entry.getValue();
            System.out.println(key + " 得分是：" + value);
        }

        System.out.println("-----------------------");

        // [4]调用 Map 集合对象的 forEach() 方法
        scoreMap.forEach((key, value) -> System.out.println(key + " 得分是：" + value));
    }
}
