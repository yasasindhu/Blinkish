package com.luv2code.springboot.cruddemo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="book")
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    @NotBlank(message = "Title may not be blank")
    private String title;


    @JoinColumn(name="author_name")
    @NotBlank(message = "AuthorName may not be blank")
    private String author_name;

    @Column(name="description")
    private String description;

    @Column(name="category")
    @NotBlank(message = "category may not be blank")
    private String category;

    public Book(String title, String author_name, String description, String category) {
        this.title = title;
        this.author_name = author_name;
        this.description = description;
        this.category = category;
    }
}
