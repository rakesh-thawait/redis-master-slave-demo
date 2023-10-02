package com.rt.redismasterslavedemo.repo;


import com.rt.redismasterslavedemo.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {
    Optional<Book> findByIsbn(String isbn);
}
