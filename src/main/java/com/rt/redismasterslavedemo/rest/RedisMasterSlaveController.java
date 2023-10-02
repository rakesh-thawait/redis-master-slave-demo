package com.rt.redismasterslavedemo.rest;

import com.rt.redismasterslavedemo.domain.Book;
import com.rt.redismasterslavedemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class RedisMasterSlaveController {

    @Autowired
    BookService bookService;

    @PostMapping("/book")
    public ResponseEntity<Book> save(@RequestBody Book book) {
        bookService.save(book);
        return ResponseEntity.ok(book);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBook(@PathVariable String isbn) {
        Book book = bookService.getBook(isbn);
        return ResponseEntity.ok(book);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id) {
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }
}
