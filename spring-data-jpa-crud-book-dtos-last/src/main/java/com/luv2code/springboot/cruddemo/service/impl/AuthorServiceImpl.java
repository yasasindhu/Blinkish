package com.luv2code.springboot.cruddemo.service.impl;

import com.luv2code.springboot.cruddemo.dao.AuthorRepository;
import com.luv2code.springboot.cruddemo.entity.Author;
import com.luv2code.springboot.cruddemo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl  implements AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository theAuthorRepository){
        authorRepository=theAuthorRepository;
    }
    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(String theId) {
        Optional<Author> result = authorRepository.findById(theId);
        Author theAuthor=null;
        if(result.isPresent()){
            theAuthor=result.get();
        }
        else{
            //we didn't find the author
            throw new RuntimeException("Did not find author");
        }
        return theAuthor;
    }

    @Override
    public Author save(Author theAuthor) {
        authorRepository.save(theAuthor);
        return theAuthor;
    }

    @Override
    public void deleteById(String theId) {
        authorRepository.deleteById(theId);
    }


}
