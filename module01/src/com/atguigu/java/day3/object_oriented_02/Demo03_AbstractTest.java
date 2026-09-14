package com.atguigu.java.day3.object_oriented_02;

public class Demo03_AbstractTest {

    public static void main(String[] args) {
        // 抽象类不能直接实例化
        // Teacher teacher = new Teacher();

        // 子类继承抽象类之后实现了抽象方法，消除了抽象类中的不确定性，所以可以实例化了
        // 抽象类作为父类可以作为变量的类型，它只是不能创建对象而已
        Teacher teacher = new TeacherHistory();
        teacher.talk();
        System.out.println(teacher.getSalary());
    }

}
