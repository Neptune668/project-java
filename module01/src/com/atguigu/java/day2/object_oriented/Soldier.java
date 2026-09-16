package com.atguigu.java.day2.object_oriented;

/**
 * Soldier 类代表士兵
 * 【属性】体现在代码上就是『成员变量』，写在类的大括号中，不写在方法体内
 * 姓名
 * 武器
 * 年龄
 * 工资
 * 【行为】
 * 攻击
 * 防守
 */
public class Soldier {

    // 士兵姓名
    String soldierName = "阿甘";

    // 士兵武器
    String soldierWeapon = "M16";

    // 士兵年龄
    int age = 25;

    // 士兵工资
    double salary = 1000.00;

    // 攻击行为对应的方法
    public void attack() {
        // 双引号内的变量名不会被当做变量解析成变量的值，就只当做普通字符串打印
        // System.out.println("soldierName士兵使用soldierWeapon武器对敌人发起攻击！");

        // 需要拼接字符串才能引用变量
        System.out.println(this.soldierName + "士兵使用" + this.soldierWeapon + "武器对敌人发起攻击！");
    }

    public void attack(String enemyName) {
        System.out.println(soldierName + "士兵使用" + soldierWeapon + "武器对" + enemyName + "敌人发起攻击！");
    }

    // 防守行为对应的方法
    public void defense() {
        System.out.println(soldierName + "士兵进入防御状态！");
    }

    @Override
    public String toString() {
        return "Soldier{" +
                "soldierName='" + soldierName + '\'' +
                ", soldierWeapon='" + soldierWeapon + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
