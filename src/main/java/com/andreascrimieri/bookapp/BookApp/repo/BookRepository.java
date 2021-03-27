package com.andreascrimieri.bookapp.BookApp.repo;


import com.andreascrimieri.bookapp.BookApp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findBookById(String id);
    List<Book> findBookByTitleContainingIgnoreCase(String title);

    List<Book> findByUsers_id(String id);
    void deleteById(String id);
}
