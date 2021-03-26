package com.andreascrimieri.bookapp.BookApp.service;

import com.andreascrimieri.bookapp.BookApp.exception.BookNotFoundException;
import com.andreascrimieri.bookapp.BookApp.model.Book;
import com.andreascrimieri.bookapp.BookApp.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookService {


    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public Book findBookById(Long id){
        return bookRepository.findBookById(id).orElseThrow(() -> new BookNotFoundException("Book by id "+ id +" was not found"));
    }

    public List<Book> findBookByTitle(String title){
        return bookRepository.findBookByTitleContainingIgnoreCase(title);
    }

    public Book updateBook(Book book){
        return bookRepository.save(book);
    }

    public void deleteBook(Long id){
        bookRepository.deleteBookById(id);
    }

}
