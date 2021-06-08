package com.luv2code.springboot.cruddemo;

import com.luv2code.springboot.cruddemo.dao.AuthorRepository;
import com.luv2code.springboot.cruddemo.dao.BookRepository;
import com.luv2code.springboot.cruddemo.entity.Author;
import com.luv2code.springboot.cruddemo.entity.Book;
import com.luv2code.springboot.cruddemo.service.AuthorService;
import com.luv2code.springboot.cruddemo.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class CruddemoApplicationTests {

	@Test
	void contextLoads() {
	}




}
