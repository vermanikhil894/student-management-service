package com.maddy.studentmanagementservice.service;

import com.maddy.studentmanagementservice.exception.ResourceNotFoundException;
import com.maddy.studentmanagementservice.model.Book;
import com.maddy.studentmanagementservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBookDetails(Book updatedBook, Long id) {
        updatedBook.setBookId(id);
        return bookRepository.save(updatedBook);
    }

    public Book findBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book by id " + id + " was not found"));
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }


}
