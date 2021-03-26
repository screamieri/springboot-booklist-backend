package com.andreascrimieri.bookapp.BookApp.resource;

import com.andreascrimieri.bookapp.BookApp.model.Book;
import com.andreascrimieri.bookapp.BookApp.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/book")
public class BookResource {


    private final BookService bookService;

    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book/all")
    public ResponseEntity<List<Book>> getAllBooks () {
        List<Book> books = bookService.findAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/book/find/id/{id}")
    public ResponseEntity<Book> getBookByTitle(@PathVariable("id") Long id){
        Book book = bookService.findBookById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/book/find/title/{title}")
    public ResponseEntity<List<Book>> getBookByTitle(@PathVariable("title") String title){
        List<Book> booksByTitle = bookService.findBookByTitle(title);
        return new ResponseEntity<>(booksByTitle, HttpStatus.OK);
    }

    @PostMapping("/book/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book newBook = bookService.addBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
    }

    @PutMapping("/book/update")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        Book updatedBook = bookService.updateBook(book);
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping("/book/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
