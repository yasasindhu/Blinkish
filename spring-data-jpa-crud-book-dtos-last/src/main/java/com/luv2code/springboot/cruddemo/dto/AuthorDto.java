package com.luv2code.springboot.cruddemo.dto;

import com.luv2code.springboot.cruddemo.entity.Book;
import lombok.Data;

import java.util.List;

@Data
public class AuthorDto {

    private String name;

    private List<Book> book;
}
