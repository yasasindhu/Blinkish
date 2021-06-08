package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.AuthorRepository;
import com.luv2code.springboot.cruddemo.entity.Author;
import org.junit.Test;
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
public class AuthorServiceTests {
    @Autowired
    private AuthorService authorService;

    @MockBean
    private AuthorRepository theAuthorRepository;

    @Test
    public void getAuthorsTest(){
        when(theAuthorRepository.findAll()).thenReturn(Stream.of( new Author("Craig")).collect(Collectors.toList()));
        assertEquals(1,authorService.findAll().size());
    }

    @Test
    public void getAuthorsById(){
        String authId="Craig";
        Author author=new Author("Craig");
        when(theAuthorRepository.findById(authId)).thenReturn(java.util.Optional.of(author));
        assertEquals(author,authorService.findById(authId));
    }

    @Test
    public void saveAuthors(){
        String authId="Yasa";
        Author author=new Author("Yasa");
        when(theAuthorRepository.save(author)).thenReturn(author);
        assertEquals(author,authorService.save(author));
    }

    @Test
    public void deleteAuthorsById(){
        String authId="Craig";
        Author author=new Author("Craig");
        authorService.deleteById(authId);
        verify(theAuthorRepository,times(1)).deleteById(authId);
    }

}
