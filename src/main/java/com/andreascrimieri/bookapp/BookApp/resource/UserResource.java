package com.andreascrimieri.bookapp.BookApp.resource;

import com.andreascrimieri.bookapp.BookApp.dto.BookDto;
import com.andreascrimieri.bookapp.BookApp.model.Book;
import com.andreascrimieri.bookapp.BookApp.model.User;
import com.andreascrimieri.bookapp.BookApp.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id){
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /*@PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }*/

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id){
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/books")
    public ResponseEntity<List<BookDto>> getAllUserBooks(@PathVariable("id") String id){
        List<Book> books = userService.findAllBooksForUser(id);
        List<BookDto> booksDto = books.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(booksDto, HttpStatus.OK);
    }

    @PutMapping("/{user_id}/book/{book_id}")
    public ResponseEntity<User> addUserBook(@PathVariable("user_id") String userId, @PathVariable("book_id") String bookId){
        User updatedUser = userService.addBookToUser(userId, bookId);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @PutMapping("/{user_id}/book/add")
    public ResponseEntity<User> addUserBook(@PathVariable("user_id") String userId, @RequestBody Book book){
        User updatedUser = userService.addBookToUser(userId, book);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    private BookDto convertToDto(Book book){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        BookDto bookDto = modelMapper.map(book, BookDto.class);
        //UserBook user = book.getUsers().stream().map(Optional::ofNullable).findFirst().orElseGet(Optional::empty).orElse(null);
        return bookDto;
    }

    private Book converToEntity(BookDto bookDto) throws ParseException{
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        Book post = modelMapper.map(bookDto, Book.class);
        return post;
    }

}
