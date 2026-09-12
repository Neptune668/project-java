package com.atguigu.java.test.day2;

/**
 * 士兵类
 * 属性：姓名、武器、年龄、工资
 * 行为：攻击、防守
 */
public class Soldier {
    private String name;
    private String weapon;
    private int age;
    private double salary;
    // 攻击行为对应的方法
    public void attack() {
        System.out.println(name + "士兵使用" + weapon + "武器对敌人发起攻击！");
    }
    // 攻击行为对应的方法2
    public void attack(String enemyName) {
        System.out.println(name + "士兵使用" + weapon + "武器对" + enemyName + "敌人发起攻击！");
    }

    // 防御方法
    public void defense() {
        System.out.println(name + "士兵进入防御状态！");
    }

    @Override
    public String toString() {
        return "Soldier{" +
                "name='" + name + '\'' +
                ", weapon='" + weapon + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
