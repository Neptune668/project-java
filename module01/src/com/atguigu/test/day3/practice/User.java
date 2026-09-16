package com.atguigu.test.day3.practice;

public class User {
    private String username;
    private String password;
    private static int userCount = 0; // 静态属性，初始 0

    // 无参构造：通过 this(...) 委托给有参构造
    public User() {
        // 此时 userCount 还没自增，有参构造中会 userCount++
        // 所以这里用 userCount + 1，正好是自增后的序号 N
        this("guest_" + (userCount + 1), "123456");
    }

    // 有参构造
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        userCount++; // 每创建一个 User 对象，userCount 自增
    }

    public static int getUserCount() {
        return userCount;
    }

    public String getUsername() {
        return username;
    }

    public static void main(String[] args) {
        new User("zhangsan", "abc123");

        // 保存无参构造创建出的对象，便于最后获取用户名
        User guestUser = new User();

        new User("lisi", "123");

        System.out.println(User.getUserCount());
        System.out.println(guestUser.getUsername());
    }
}