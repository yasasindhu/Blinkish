package com.luv2code.springboot.cruddemo.service.impl;

import com.luv2code.springboot.cruddemo.dao.BookRepository;
import com.luv2code.springboot.cruddemo.entity.Book;
import com.luv2code.springboot.cruddemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository theBookRepository){
        bookRepository=theBookRepository;
    }


    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int theId) {
        Optional<Book> result = bookRepository.findById(theId);
        Book theBook=null;
        if(result.isPresent()){
            theBook=result.get();
        }
        else{
            //we didn't find the employee
            throw new RuntimeException("Did not find Book");        }
        return theBook;
    }

    @Override
    public Book save(Book theBook) {
        bookRepository.save(theBook);
        return theBook;
    }

    @Override
    public void deleteById(int theId) {
        bookRepository.deleteById(theId);
    }
}
