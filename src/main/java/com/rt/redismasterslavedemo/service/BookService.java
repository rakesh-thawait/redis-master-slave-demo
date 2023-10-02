package com.rt.redismasterslavedemo.service;

import com.rt.redismasterslavedemo.domain.Book;
import com.rt.redismasterslavedemo.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository repository;

    public void save(Book book) {
        repository.save(book);
    }

    public Book getBook(String isbn) {
        if (repository.findByIsbn(isbn).isPresent()) {
            return repository.findByIsbn(isbn).get();
        } else {
            return null;
        }
    }

    public Book getBookById(String id) {
        return repository.findById(id).get();
    }

    public void updateBook(Book book) {
        repository.save(book);
    }

    public void deleteBook(Book book) {
        repository.delete(book);
    }
}
