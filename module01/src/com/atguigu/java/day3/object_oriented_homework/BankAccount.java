package com.atguigu.java.day3.object_oriented_homework;

public class BankAccount {

    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {

        if (balance < 0) {
            System.out.println("操作失败：余额不能为负数！");
        } else {
            this.balance = balance;
        }

    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBalance(500);
        System.out.println(bankAccount.getBalance());
        bankAccount.setBalance(-10000);
        System.out.println(bankAccount.getBalance());
    }
}
