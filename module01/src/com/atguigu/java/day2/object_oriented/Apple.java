package com.atguigu.java.day2.object_oriented;

public class Apple {

    // private 声明私有属性
    private String propNamePrivate;

    // 没有设置权限修饰符将采用 default 范围
    String propNameDefault;

    // protected 声明受保护属性
    protected String propNameProtected;

    // public 声明公共属性
    public String propNamePublic;

    public void setPropNamePrivate(String propNamePrivate) {
        // 在本类内部，可以访问私有属性
        this.propNamePrivate = propNamePrivate;
    }

    public void setPropNameDefault(String propNameDefault) {
        // 在本类内部，可以访问默认属性
        this.propNameDefault = propNameDefault;
    }

    public void setPropNameProtected(String propNameProtected) {
        this.propNameProtected = propNameProtected;
    }

    public void setPropNamePublic(String propNamePublic) {
        this.propNamePublic = propNamePublic;
    }
}
