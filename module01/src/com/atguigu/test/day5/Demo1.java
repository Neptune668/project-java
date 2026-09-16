package com.atguigu.test.day5;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Demo1 {
    @Test
    public void test1() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate birthday = LocalDate.parse("2000/01/01", formatter);
        User user = new User("zhangsan", "abc", birthday);
        System.out.println(user.getAge());
    }
    @Test
    public void test2() {
        User user = new User();
        user.setUsername("lisi");
        System.out.println(user.getUsername());
    }
}

class User {
    private String username;
    private String password;
    private LocalDate birthday; // 2000-10-25 2026-09-16

    // 计算用户的年龄
    public int getAge() {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonth().getValue();
        int day = today.getDayOfMonth();
        if (month > birthday.getMonth().getValue() ||
                (month == birthday.getMonth().getValue() && day > birthday.getDayOfMonth())) {
            return year - birthday.getYear();
        }
        return year - birthday.getYear() - 1;
    }

    public User(String username, String password, LocalDate birthday) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.username = username;
        this.password = password;
        this.birthday = birthday;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
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

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
