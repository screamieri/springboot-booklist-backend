package com.andreascrimieri.bookapp.BookApp.service;

import com.andreascrimieri.bookapp.BookApp.exception.BookNotFoundException;
import com.andreascrimieri.bookapp.BookApp.model.Book;
import com.andreascrimieri.bookapp.BookApp.model.User;
import com.andreascrimieri.bookapp.BookApp.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserService userService;

    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public Book findBookById(String id){
        return bookRepository.findBookById(id).orElseThrow(() -> new BookNotFoundException("Book by id "+ id +" was not found"));
    }

    public List<Book> findBookByTitle(String title){
        return bookRepository.findBookByTitleContainingIgnoreCase(title);
    }

    public Book updateBook(Book book){
        return bookRepository.save(book);
    }

    public void deleteBook(String id){
        bookRepository.deleteById(id);
    }

    public Book findBookByIsbn(String ibsn){
        return bookRepository.findBookByIsbn(ibsn).orElse(null);
    }

    public List<Book> getAllBooksByUserId(String id){
        return bookRepository.findByUsers_id(id);
    }

    public List<User> getAllUsersByBookId(String id){
        return userService.findAllUsersForBook(id);
    }

}
