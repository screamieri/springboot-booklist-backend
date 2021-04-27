package com.andreascrimieri.bookapp.BookApp.service;

import com.andreascrimieri.bookapp.BookApp.exception.UserBookNotFoundException;
import com.andreascrimieri.bookapp.BookApp.model.UserBook;
import com.andreascrimieri.bookapp.BookApp.repo.UserBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserBookService {

    @Autowired
    UserBookRepository userBookRepository;

    public UserBook findByUserIdBookId(String userId, String bookId){
        return this.userBookRepository.findByIdUserIdAndIdBookId(userId, bookId).orElseThrow(() -> new UserBookNotFoundException("The user book relationship for "+ userId +" " + bookId +"was not found"));
    }

    public UserBook updateUserBook(UserBook userBook){
        return this.userBookRepository.save(userBook);
    }

}
