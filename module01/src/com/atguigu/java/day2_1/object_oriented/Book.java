package com.atguigu.java.day2_1.object_oriented;

/**
 * 实际开发时规范标准的实体类写法
 * 成员变量全部使用 private 修饰
 * 针对成员变量的读写操作，全部由 public 的 getXxx()、setXxx() 方法来执行（快捷方式：通过 Alt + Insert 调出 Generate 菜单）
 * 必须提供无参的构造器（快捷方式：通过 Alt + Insert 调出 Generate 菜单）
 * 有参构造器可选
 * toString() 方法可选
 *
 * 从成员变量名称到 getter、setter 方法名是有确定性规则的：
 * 成员变量名首字母大写然后前面加上 get 或 set
 */
public class Book {

    private String bookName;
    private double bookPrice;
    private String author;

    public Book() {
    }

    public Book(String bookName, double bookPrice, String author) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                ", author='" + author + '\'' +
                '}';
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
