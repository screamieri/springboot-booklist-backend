package com.andreascrimieri.bookapp.BookApp.repo;

import com.andreascrimieri.bookapp.BookApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {




    Optional<User> findById(String id);
    void deleteById(String id);
    List<User> findByBooks_id(String id);
    Optional<User> findByEmail(String email);
}
