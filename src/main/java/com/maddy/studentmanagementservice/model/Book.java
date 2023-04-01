package com.maddy.studentmanagementservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookId;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "published_year")
    private String publishedYear;

    @Column(name = "author_name")
    private String author;

    @Column(name = "number_of_books")
    private long numberOfBooks;

    public Book() {
    }

    public Book(String bookName, String publishedYear, String author, long numberOfBooks) {
        this.bookName = bookName;
        this.publishedYear = publishedYear;
        this.author = author;
        this.numberOfBooks = numberOfBooks;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
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
