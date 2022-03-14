package com.rest.app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
     @Autowired
    private BookRepository bookRepository;

     @GetMapping("/books")
    public List<Book> getAllBookRecords(){
         return bookRepository.findAll();
     }

     @GetMapping(value = "{bookId}")
    public Book getBook(@PathVariable(value = "bookId")Long bookId){
         return bookRepository.findById(bookId).get();
     }

     @PostMapping
    public Book CreateBookRecord(@RequestBody Book bookRecord){
         return bookRepository.save(bookRecord);
     }

     @PutMapping
    public Book updateBookRecord(@RequestBody Book bookRecord){
         if (bookRecord==null || bookRecord.getBookId()==null){

         }
         return bookRepository.save(bookRecord);
    }

}

