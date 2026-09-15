package com.atguigu.java.day4.lambda;

public class Demo02_LambdaSimpleTest {

    public static void main(String[] args) {
        // 1、省略参数类型
        // 只要是能够确定的参数类型就可以省略，具体类型或能推断出的泛型类型都可以
        PlayGame playGame = (playerOne, playerTwo) -> {
            System.out.println(playerOne + " 和 " + playerTwo + "一起玩魂斗罗~~~");
        };
        playGame.twoPlayerPlayGame("小红", "小明");

        // 2、省略单参数的括号
        // 3、Lambda体中单条语句时省略 {}
        HaveBreakfast haveBreakfast = n -> System.out.println(n + " 正在吃早餐~~~");
        haveBreakfast.breakfast("小明");

        // 4、Lambda体中单条 return 语句时省略 return 和 {}
        BuySomething buySomething = money -> "花" + money + "这么多钱，买了79元的眉笔";
        System.out.println(buySomething.buyItByMoney("79"));
    }

}
