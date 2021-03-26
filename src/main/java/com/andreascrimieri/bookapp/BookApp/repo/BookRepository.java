package com.andreascrimieri.bookapp.BookApp.repo;


import com.andreascrimieri.bookapp.BookApp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Long> {
}
