package com.atguigu.java.test.day3.practice;

//        8. 设计一个 BankAccount（银行账户）类：私有属性 balance（double）
//        提供 setBalance 方法——余额小于 0 时打印"操作失败：余额不能为负数！"并拒绝赋值，
//        提供 getBalance 方法。在 main 中分别用 -10000 和 500 验证。
public class BankAccount {
    private double balance;
//
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance > 0) {
            this.balance = balance;
        } else {
            System.out.println("余额小于 0 时打印\"操作失败：余额不能为负数！");
        }
    }
}