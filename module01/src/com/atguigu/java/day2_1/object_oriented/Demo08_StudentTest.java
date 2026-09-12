package com.atguigu.java.day2_1.object_oriented;

public class Demo08_StudentTest {

    public static void main(String[] args) {
        // 1、调用无参构造器创建 Student 对象
        Student student01 = new Student();

        // 2、调用有参构造器创建 Student 对象
        Student student02 = new Student("王小明", 50);

        // 3、调用 setter 方法给第一个 Student 对象设置属性值
        student01.setName("王大明");
        student01.setAge(18);

        // 4、调用 getter 方法获取第一个和第二个 Student 对象的属性值
        System.out.println("学生姓名：" + student01.getName());
        System.out.println("学生年龄：" + student01.getAge());

        System.out.println("学生姓名：" + student02.getName());
        System.out.println("学生年龄：" + student02.getAge());

        // 5、在 for 循环中创建多个 Student 对象
        for (int i = 0; i < 10; i++) {
            new Student();
        }

        // 6、获取学生对象总数
        int totalStudents = Student.getTotalStudents();
        System.out.println("学生对象总数 = " + totalStudents);
    }

}
