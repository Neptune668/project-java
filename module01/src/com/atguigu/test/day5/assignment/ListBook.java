package com.atguigu.test.day5.assignment;

import java.util.*;

public class ListBook {
    //• List<Book>：存储图书列表，支持有序遍历
    //• Map<String, Book>：建立ID索引，快速查找
    //• Set<String>：存储作者信息，自动去重
    private List<Book> books = new ArrayList<>();
    private Map<String, Book> bookMap = new HashMap<>();
    private Set<String> authors = new HashSet<>();

    public ListBook() {
    }

    public ListBook(List<Book> books, Map<String, Book> bookMap, Set<String> authors) {
        this.books = books;
        this.bookMap = bookMap;
        this.authors = authors;
    }

    //书名查询
    public Book getBookByTitle(String title) {
        return bookMap.get(title);
    }
    //作者查询
    public Book getBookByAuthors(String author){
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                return book;
            }
        }
        return null;
    }
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Map<String, Book> getBookMap() {
        return bookMap;
    }

    public void setBookMap(Map<String, Book> bookMap) {
        this.bookMap = bookMap;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<String> authors) {
        this.authors = authors;
    }

    public void addBook(Book book) {
        books.add(book);
        bookMap.put(book.getTitle(), book);
        authors.add(book.getAuthor());
    }

    @Override
    public String toString() {
        return "ListBook{" +
                "books=" + books +
                ", bookMap=" + bookMap +
                ", authors=" + authors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ListBook listBook = (ListBook) o;
        return Objects.equals(books, listBook.books) && Objects.equals(bookMap, listBook.bookMap) && Objects.equals(authors, listBook.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books, bookMap, authors);
    }
}
