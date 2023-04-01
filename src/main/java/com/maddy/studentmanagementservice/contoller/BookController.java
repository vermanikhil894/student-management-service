package com.maddy.studentmanagementservice.contoller;

import com.maddy.studentmanagementservice.dto.BookRequest;
import com.maddy.studentmanagementservice.model.Book;
import com.maddy.studentmanagementservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks () {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById (@PathVariable("id") Long id) {
        Book book = bookService.findBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }


//    @PostMapping("/books")
//    public ResponseEntity<Book> addBook(Book book) {
//        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.CREATED);
//    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") long id) {
        Book updatedBook = bookService.updateBookDetails(book, id);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody BookRequest bookRequest) {
        Book book = new Book();
        book.setBookName(bookRequest.getBookName());
        book.setAuthor(bookRequest.getAuthor());
        book.setPublishedYear(bookRequest.getPublishedYear());
        book.setNumberOfBooks(bookRequest.getNumberOfBooks());
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.CREATED);
    }

}
