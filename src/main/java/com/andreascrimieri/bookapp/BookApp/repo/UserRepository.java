package com.andreascrimieri.bookapp.BookApp.repo;

import com.andreascrimieri.bookapp.BookApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByBooks_id(Long id);

}
