package com.andreascrimieri.bookapp.BookApp.resource;

import com.andreascrimieri.bookapp.BookApp.model.Book;
import com.andreascrimieri.bookapp.BookApp.model.User;
import com.andreascrimieri.bookapp.BookApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/{id}/books")
    public ResponseEntity<List<Book>> getAllUserBooks(@PathVariable("id") Long id){
        List<Book> books = userService.getAllUserBooks(id);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }


    @PutMapping("/{user_id}/book/{book_id}")
    public ResponseEntity<User> addUserBook(@PathVariable("user_id") Long userId, @PathVariable("book_id") Long bookId){
        User updatedUser = userService.addBookToUser(userId, bookId);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

}
