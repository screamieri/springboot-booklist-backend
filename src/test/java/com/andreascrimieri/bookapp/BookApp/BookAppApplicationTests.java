package com.andreascrimieri.bookapp.BookApp;

import com.andreascrimieri.bookapp.BookApp.service.BookService;
import com.andreascrimieri.bookapp.BookApp.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@TestPropertySource(locations="classpath:application-test.properties")
@AutoConfigureMockMvc
class BookAppApplicationTests {

	@Autowired
	BookService bookService;
	@Autowired
	UserService userService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void userIdGetShouldReturnUserJson(){

	}

}
