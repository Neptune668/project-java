package com.atguigu.java.day4.generic;

public class Demo01_GenericTest {

    public static void main(String[] args) {
        // 测试泛型类
        // new Bowl<>() 这里不需要传入泛型类型，是因为前面 Bowl<Rice> 设定之后，底层编译器可以自动推断
        Bowl<Rice> riceBowl = new Bowl<>(new Rice());

        riceBowl.contain(new Rice());

        Bowl<Soup> soupBowl = new Bowl<>(new Soup());
        // 已经通过泛型限定了当前 Bowl 对象必须使用 Soup 类型的泛型数据，使用别的就会报错
        // soupBowl.contain(new Rice());
        soupBowl.contain(new Soup());

        Bowl<Noodle> noodleBowl = new Bowl<>(new Noodle());
        noodleBowl.contain(new Noodle());

        // 测试泛型方法
        boolean checkResult = riceBowl.foodTool(new Chopsticks());
        System.out.println("米饭和筷子：" + (checkResult ? "匹配" : "不匹配"));

        checkResult = soupBowl.foodTool(new KnifeAndFork());
        System.out.println("汤和刀叉：" + (checkResult ? "匹配" : "不匹配"));
    }

}
