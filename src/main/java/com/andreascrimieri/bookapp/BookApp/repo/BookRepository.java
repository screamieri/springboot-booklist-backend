package com.andreascrimieri.bookapp.BookApp.repo;


import com.andreascrimieri.bookapp.BookApp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface BookRepository extends JpaRepository<Book, String> {

    Optional<Book> findBookById(String id);

    void deleteById(String id);

    List<Book> findBookByTitleContainingIgnoreCase(String title);

    List<Book> findByUsers_userId(String id);

    Optional<Book> findBookByIsbn(String isbn);

}
