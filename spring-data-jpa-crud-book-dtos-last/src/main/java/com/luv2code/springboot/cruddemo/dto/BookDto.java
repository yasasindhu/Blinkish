package com.luv2code.springboot.cruddemo.dto;

import com.luv2code.springboot.cruddemo.entity.Author;
import lombok.Data;

@Data
public class BookDto {
    private int id;
    private String title;
    private String author_name;
    private String description;
    private String category;
}
