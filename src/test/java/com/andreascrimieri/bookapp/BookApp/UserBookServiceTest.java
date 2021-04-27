package com.andreascrimieri.bookapp.BookApp;

import com.andreascrimieri.bookapp.BookApp.exception.UserBookNotFoundException;
import com.andreascrimieri.bookapp.BookApp.model.UserBook;
import com.andreascrimieri.bookapp.BookApp.service.UserBookService;
import com.andreascrimieri.bookapp.BookApp.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@TestPropertySource(locations="classpath:application-test.properties")
@AutoConfigureMockMvc
@Transactional
public class UserBookServiceTest {



	@Autowired
	UserBookService userBookService;

	@Autowired
	UserService userService;

	@Test
	public void findUserBookBy_userId_bookId_should_return_not_null(){

		String bookId = "764b29ce-c1a0-4909-9f3e-addc2345ed7e";
		String userId = "587ed148-8f1a-11eb-8dcd-0242ac130003";

		UserBook userBook = this.userBookService.findByUserIdBookId(userId, bookId);

		assertNotNull(userBook);
	}

	@Test
	//@Rollback(false)
	public void updateExistingUserBook_should_not_return_null(){

		String bookId = "764b29ce-c1a0-4909-9f3e-addc2345ed7e";
		String userId = "587ed148-8f1a-11eb-8dcd-0242ac130003";

		UserBook userBook = this.userBookService.findByUserIdBookId(userId, bookId);

		userBook.setCurrentPage(50);
		userBook.setRating(3);

		UserBook updatedUserBook = this.userBookService.updateUserBook(userBook);

		assertNotNull(updatedUserBook);
	}

	@Test
	public void removeExistingBookFromExistingUser_shouldThrowUserBookNotFoundException(){

		String bookId = "764b29ce-c1a0-4909-9f3e-addc2345ed7e";
		String userId = "587ed148-8f1a-11eb-8dcd-0242ac130003";

		this.userService.deleteBookFromUser(userId, bookId);

		assertThrows(UserBookNotFoundException.class, () -> {
			UserBook userBook = this.userBookService.findByUserIdBookId(userId, bookId);
		});
	}


}
