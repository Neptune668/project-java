package com.atguigu.java.exception;

public class Demo03_DefenseCoding {

    public static void main(String[] args) {

    }

    /**
     * 防御性编程：当我声明的方法给别人调用，此时我不知道传入的参数是否合规，所以我需要在数据使用前先进行检查
     * @param info
     */
    public void showInfo(String info) {

        if (info == null) {
            throw new RuntimeException("info必须有值！");
        }

        System.out.println(info.length());
    }
}
