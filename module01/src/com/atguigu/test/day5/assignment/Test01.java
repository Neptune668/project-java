package com.atguigu.test.day5.assignment;

import org.junit.Test;


public class Test01 {
    @Test
    public void test01() {
        ListBook listBook = new ListBook();
        listBook.addBook(new Book(1, "Java", "Tom", 100.0));
        Book book = new Book(2, "python", "Jack", 120.0);
        listBook.addBook(book);
        System.out.println(listBook);
        System.out.println("*".repeat(50));

        //通过作者和书名进行查询
        System.out.println(listBook.getBookByTitle("Java"));
        System.out.println(listBook.getBookByAuthors("Jack"));
        System.out.println(listBook.getAuthors());
        System.out.println(listBook.getBooks());
        System.out.println(listBook.getBookMap());
    }
}
