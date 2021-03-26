package com.andreascrimieri.bookapp.BookApp.repo;

import com.andreascrimieri.bookapp.BookApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
