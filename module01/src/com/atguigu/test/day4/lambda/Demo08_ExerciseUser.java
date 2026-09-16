package com.atguigu.test.day4.lambda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Demo08_ExerciseUser {

    public static void main(String[] args) {

        // 根据用户的生日创建 LocalDate 对象
        LocalDate birthday = LocalDate.parse("2000-10-25", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // 创建 User 对象
        User user = new User("tom2026", "123456", birthday);

        // 获取用户的年龄
        int age = user.getAge();
        System.out.println("age = " + age);

        // 设置用户名，拦截非法参数值
        user.setUsername("  d  ");
    }

}

class User {

    private String username;
    private String password;
    private LocalDate birthday; // 2000-10-25 2026-09-16

    // 计算用户的年龄
    public int getAge() {

        // 获取当前的年月日对应的日期对象
        LocalDate today = LocalDate.now();

        int todayYear = today.getYear();
        int todayMonthValue = today.getMonth().getValue();
        int todayDayOfMonth = today.getDayOfMonth();

        int birthdayYear = birthday.getYear();
        int birthdayMonthValue = birthday.getMonth().getValue();
        int birthdayDayOfMonth = birthday.getDayOfMonth();

        int age = todayYear - birthdayYear;

        if (birthdayMonthValue > todayMonthValue ||
                (birthdayMonthValue == todayMonthValue && birthdayDayOfMonth > todayDayOfMonth)) {
            age = age - 1;
        }

        return age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {

        if (username == null || username.isEmpty() || username.isBlank()) {
            // username.isEmpty() 的另一种写法："".equals(username)
            // IllegalArgumentException 代表：非法参数异常
            throw new IllegalArgumentException();
        }

        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public User(String username, String password, LocalDate birthday) {

        if (username == null || username.isEmpty()) {
            // username.isEmpty() 的另一种写法："".equals(username)
            // IllegalArgumentException 代表：非法参数异常
            throw new IllegalArgumentException();
        }

        this.username = username;
        this.password = password;
        this.birthday = birthday;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}