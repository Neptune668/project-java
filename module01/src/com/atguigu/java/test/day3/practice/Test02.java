package com.atguigu.java.test.day3.practice;

public class Test02 {
    public static void main(String[] args) {
//        BankAccount account = new BankAccount();
//        account.setBalance(-10000);
//        System.out.println(account.getBalance());
//
//        account.setBalance(500);
//        System.out.println(account.getBalance());

//        9. 设计一个 User 类：私有属性 username、password，
//        静态属性 userCount（int，初始 0）；无参构造通过 this(...) 委托给有参构造，
//        用户名自动生成 guest_N（N 为自增序号，即 userCount 递增后的值）、默认密码 "123456"；
//        有参构造接收用户名和密码并让 userCount 自增。
//        在 main 中依次创建 new User("zhangsan","abc123")、
//        new User()、new User("lisi","123")，最后打印 User.getUserCount() 和无参构造创建出的用户名。
        User user1 = new User("zhangsan","abc123");
//        System.out.println(user1.getUsername() + "," + user1.getPassword());
//        10. 设计一个 Car 类，通过构造方法重载支持三种创建方式：
//        无参（品牌默认"未知"）、仅传品牌、传品牌和价格；属性私有并提供 getter。
//        在 main 中用三种方式各创建一辆车并打印信息。
    }
}
