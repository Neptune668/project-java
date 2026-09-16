package com.atguigu.java.day5.other;

import java.util.Objects;

/**
 * HASH 算法：输入数据经过算法内部的数学计算得到一个固定长度的整数值
 * 特点 1：只要输入不变，输出就不变
 * 特点 2：输入数据有任何哪怕细微的变化，输出就一定会变，而且通常是很大的改变
 * 特点 3：不可逆
 *
 * Object 类中的 hashCode() 方法功能就是计算具体一个对象的 HASH 值
 * 输入数据：对象的二进制数据
 * 输出结果：整数类型的 HASH 值
 *
 * 对象的 HASH 值（hashCode()方法的返回值）的应用场景：
 * Java 中 HashSet 集合是一个有去重功能的容器，多个对象存入 HashSet 这个集合就会自动去重
 * HashSet 执行去重操作大致的逻辑是：一个萝卜一个坑，把萝卜往坑里放的时候会检查当前萝卜和现在坑里的萝卜是不是同一个萝卜
 * HashSet 会首先比较两个萝卜的 hashCode() 值看是否相等：
 *      不等：直接判断这是两个不同的萝卜，手里这个萝卜就要放入其它坑
 *      相等：还需要进一步调用 equals() 方法比较两个萝卜是否相等
 *          相等：就使用手里的萝卜替换坑里的萝卜
 *          不等：把手里的萝卜放到其它坑
 * 结论：如果某个类需要进行是否相等的判断，必须遵循如下规则——
 *      equals() 方法判断两个对象相等，那么它们的 hashCode() 值也必须相等
 *      hashCode() 值相等但 equals() 方法判断不相等可以
 * 举一个反例：假如两个对象调用 equals() 方法判定为相等，但 hashCode() 值不相等，会造成什么后果？
 *      对象 A 放入 HashSet 集合时，发现当前位置已经存入对象 B
 *      比较 A 和 B 的 hashCode() 值是否相等，结果是不相等
 *      所以需要把 A 放到其它位置，HashSet 集合中同时存储了 A 和 B
 *      但是其实 A 和 B 用 equals() 比较是相等的，从业务数据角度来看是同一个对象
 *      这就破坏了 HashSet 去重的功能！！！
 * 以后我们在开发中的具体做法：
 *      如果一个类需要放入 HashMap、HashSet 或需要比较两个对象是否相等，那就需要让 hashCode() 方法和 equals() 方法配套
 *      equals() 比较的属性，也要用于在 hashCode() 方法中生成 HASH 值
 *  所以核心最关键的就是做到一点：需要生成 equals() 和 hashCode() 方法时使用 IDEA 提供的快捷生成方式即可
 */
public class Demo04_HashCodeEquals {

    private String attrName;
    private Double attrPrice;
    private Integer attrId;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Demo04_HashCodeEquals that = (Demo04_HashCodeEquals) o;
        return Objects.equals(attrName, that.attrName) && Objects.equals(attrPrice, that.attrPrice) && Objects.equals(attrId, that.attrId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attrName, attrPrice, attrId);
    }

    public static void main(String[] args) {

    }

}
