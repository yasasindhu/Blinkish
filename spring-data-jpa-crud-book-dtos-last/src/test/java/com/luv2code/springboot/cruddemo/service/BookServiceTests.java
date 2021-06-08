package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.BookRepository;
import com.luv2code.springboot.cruddemo.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTests {

    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepository theBookRepository;

    @Test
    public void getBooksTest(){
        when(theBookRepository.findAll()).thenReturn(Stream.of( new Book("Diffusion of Innovation minds","sindhuja","Learn How Innovations Are Put To Use","Enterpreneurship")).collect(Collectors.toList()));
        assertEquals(1,bookService.findAll().size());
    }
}
