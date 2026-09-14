package com.atguigu.java.day3.object_oriented_homework;

public class User {

    private String username;
    private String password;
    static private int userCount = 0;

    public User(String username, String password) {

        userCount++;

        if (username == null) {
            username = "guest_" + userCount;
        }
        if (password == null) {
            password = "123456";
        }

        this.username = username;
        this.password = password;
    }

    public User() {
        this(null, null);
    }

    public static int getUserCount() {
        return userCount;
    }

    public static void main(String[] args) {
        User user01 = new User("zhangsan", "abc123");
        System.out.println("user01.username = " + user01.username);
        System.out.println("用户数量：" + User.getUserCount());

        User user02 = new User();
        System.out.println("user02.username = " + user02.username);
        System.out.println("用户数量：" + User.getUserCount());

        User user03 = new User("lisi", "123");
        System.out.println("user03.username = " + user03.username);
        System.out.println("用户数量：" + User.getUserCount());
    }
}
