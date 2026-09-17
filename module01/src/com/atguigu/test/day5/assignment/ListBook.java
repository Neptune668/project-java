package com.atguigu.test.day5.assignment;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListBook {
    //• List<Book>：存储图书列表，支持有序遍历
    //• Map<String, Book>：建立ID索引，快速查找
    //• Set<String>：存储作者信息，自动去重
    private List<Book> books;
    private Map<String, Book> bookMap;
    private Set<String> authors;

    public ListBook() {
    }

    public ListBook(List<Book> books, Map<String, Book> bookMap, Set<String> authors) {
        this.books = books;
        this.bookMap = bookMap;
        this.authors = authors;
    }

}
