package com.andreascrimieri.bookapp.BookApp.service;

import com.andreascrimieri.bookapp.BookApp.exception.UserNotFoundException;
import com.andreascrimieri.bookapp.BookApp.model.Book;
import com.andreascrimieri.bookapp.BookApp.model.User;
import com.andreascrimieri.bookapp.BookApp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookService bookService;

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User findUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("The user with id "+ id +" was not found"));
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

    public User addBookToUser(Long userId, Long bookId){
        Book book = bookService.findBookById(bookId);
        User user = this.findUserById(userId);
        user.addBook(book);
        return user;
    }


    public List<Book> getAllUserBooks(Long id){
        return bookService.getAllBooksByUserId(id);
    }

    public List<User> getAllUsersByBookId(Long id){
        return userRepository.findByBooks_id(id);
    }



}
