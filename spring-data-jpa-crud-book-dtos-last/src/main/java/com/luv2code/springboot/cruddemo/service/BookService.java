package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Book;


import java.util.List;

public interface BookService {

    public List<Book> findAll();

    public Book findById(int theId);

    public Book save(Book theBook);

    public void deleteById(int theId);

}
