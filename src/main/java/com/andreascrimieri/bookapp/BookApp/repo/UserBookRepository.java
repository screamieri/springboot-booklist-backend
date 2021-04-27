package com.andreascrimieri.bookapp.BookApp.repo;

import com.andreascrimieri.bookapp.BookApp.model.UserBook;
import com.andreascrimieri.bookapp.BookApp.model.UserBookId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserBookRepository extends JpaRepository<UserBook, UserBookId> {

    Optional<UserBook> findByIdUserIdAndIdBookId(String userId, String bookId);
}
