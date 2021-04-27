package com.andreascrimieri.bookapp.BookApp.service;

import com.andreascrimieri.bookapp.BookApp.exception.UserNotFoundException;
import com.andreascrimieri.bookapp.BookApp.model.Book;
import com.andreascrimieri.bookapp.BookApp.model.User;
import com.andreascrimieri.bookapp.BookApp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookService bookService;

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User findUserById(String id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("The user with id "+ id +" was not found"));
    }

    public User findUserByEmail(String email){
        return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("The user with email "+ email +" was not found"));
    }

    public User addUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public void deleteUserById(String id){
        userRepository.deleteById(id);
    }

    public User addBookToUser(String userId, String bookId){
        Book book = bookService.findBookById(bookId);
        User user = this.findUserById(userId);
        user.addBook(book);
        return user;
    }

    public User addBookToUser(String userId, Book book){
        Book foundBook = bookService.findBookByIsbn(book.getIsbn());
        User user = this.findUserById(userId);
        if(foundBook == null){
            user.addBook(book);
        } else {
            user.addBook(foundBook);
        }
        return user;
    }

    public void deleteBookFromUser(String userId, String bookId){
        User user = this.findUserById(userId);
        Book book = this.bookService.findBookById(bookId);
        user.removeBook(book);
        userRepository.save(user);
    }


    public List<Book> findAllBooksForUser(String id){
        return bookService.getAllBooksByUserId(id);
    }

    public List<User> findAllUsersForBook(String id){
        return userRepository.findByBooks_id(id);
    }


}
