package com.rest.app;


import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    public Book CreateBookRecord(@RequestBody @Valid Book bookRecord){
         return bookRepository.save(bookRecord);
     }

     @PutMapping
    public Book updateBookRecord(@RequestBody Book bookRecord) throws NotFoundException {
         if (bookRecord==null || bookRecord.getBookId()==null){
                throw new NotFoundException("bookRecord or id not be null!");
         }
         Optional<Book>optionalBook=bookRepository.findById(bookRecord.getBookId());
         if (!optionalBook.isPresent()){
             throw new NotFoundException("book white id "+bookRecord.getBookId()+" does not exist");
         }
         Book bookRecordExist= optionalBook.get();
         bookRecordExist.setName(bookRecord.getName());
         bookRecordExist.setSummary(bookRecord.getSummary());
         bookRecordExist.setRating(bookRecord.getRating());

         return bookRepository.save(bookRecordExist);
    }

    // TODO : write /delete endpoint using tdd method


}

