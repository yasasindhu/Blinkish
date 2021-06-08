package com.luv2code.springboot.cruddemo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="author")
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Author {


    @Id
    @Column(name="name")
    @NotBlank(message = "Firstname  may not be blank")
    private String name;


    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="author_name")
    private List<Book> book;

    public Author(String name) {
        this.name = name;
    }
    public void addBook(Book thebook){
        if(book==null){
            book=new ArrayList<>();
        }
        book.add(thebook);
    }

}
