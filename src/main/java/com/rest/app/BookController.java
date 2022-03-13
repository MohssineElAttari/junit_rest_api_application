package com.rest.app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
     @Autowired
    private BookRepository bookRepository;

     @GetMapping("/books")
    public List<Book> getAllBookRecord(){
         return bookRepository.findAll();
     }

     @GetMapping(value = "{bookId}")
    public Book getBook(@PathVariable(value = "bookId")Long bookId){
         return bookRepository.findById(bookId).get();
     }
}
