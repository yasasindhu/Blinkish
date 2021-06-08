package com.luv2code.springboot.cruddemo.rest.Controller;


import com.luv2code.springboot.cruddemo.entity.Book;
import com.luv2code.springboot.cruddemo.dto.BookDto;
import com.luv2code.springboot.cruddemo.customExceptions.NotFoundException;
import com.luv2code.springboot.cruddemo.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class BookRestController {

    @Autowired
    private ModelMapper modelMapper;

    //autowire the BookService
    @Autowired
    private BookService bookService;

    //add mapping for GET /Books
    @GetMapping("/books")
    public List<BookDto> getBooks(){
        return bookService.findAll().stream().map(book -> modelMapper.map(book, BookDto.class))
                .collect(Collectors.toList());
    }

    //add mapping for GET /Books/{BookId}
    @GetMapping("/books/{bookId}")
    public ResponseEntity<BookDto> getBook(@PathVariable int bookId){
        Book theBook=bookService.findById(bookId);
        if(theBook==null){
            throw new NotFoundException("Book id not found -"+bookId);
        }
        // convert entity to DTO
        BookDto bookResponse = modelMapper.map(theBook, BookDto.class);

        return ResponseEntity.ok().body(bookResponse);
    }

    //add mapping for POST/Books -add new Book
    @PostMapping("/books")
    public ResponseEntity<BookDto> addBook(@Valid @RequestBody  BookDto theBookDto){

        // convert DTO to entity
        Book bookRequest = modelMapper.map(theBookDto, Book.class);

        //also just in case the pass an id in JSON ... set id to 0
        //this is force a save of new item ... instead of update
        bookRequest.setId(0);

        Book book = bookService.save(bookRequest);


        // convert entity to DTO
        BookDto bookResponse = modelMapper.map(book, BookDto.class);


        return new ResponseEntity<BookDto>(bookResponse, HttpStatus.CREATED);
    }

    //add mapping for PUT/Books -update existing Book
    @PutMapping("/books")
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto){
        // convert DTO to Entity
        Book bookRequest = modelMapper.map(bookDto, Book.class);

        int bookId= bookRequest.getId();

        Book theBook=bookService.findById(bookId);
        if(theBook==null){
            throw new NotFoundException("Book id not found -"+bookId);
        }

        Book book = bookService.save(bookRequest);

        // entity to DTO
        BookDto bookResponse = modelMapper.map(book, BookDto.class);

        return ResponseEntity.ok().body(bookResponse);

    }

    @DeleteMapping("/books/{bookId}")
    public String deleteBook(@PathVariable int bookId){

        Book tempBook=bookService.findById(bookId);
        if(tempBook==null){
            throw new NotFoundException("Book id not found -"+bookId);
        }
        bookService.deleteById(bookId);
        return "Deleted Book id- "+bookId;
    }
}
