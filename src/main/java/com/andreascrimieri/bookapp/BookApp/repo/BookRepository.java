package com.andreascrimieri.bookapp.BookApp.repo;


import com.andreascrimieri.bookapp.BookApp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findBookById(Long id);
    List<Book> findBookByTitleContainingIgnoreCase(String title);

}
