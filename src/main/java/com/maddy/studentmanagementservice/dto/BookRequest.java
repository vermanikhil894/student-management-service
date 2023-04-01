package com.maddy.studentmanagementservice.dto;

public class BookRequest {

    private String bookName;

    private String publishedYear;

    private String author;

    private long numberOfBooks;

    public BookRequest() {
    }

    public BookRequest(String bookName, String publishedYear, String author, long numberOfBooks) {
        this.bookName = bookName;
        this.publishedYear = publishedYear;
        this.author = author;
        this.numberOfBooks = numberOfBooks;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(String publishedYear) {
        this.publishedYear = publishedYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(long numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }
}
