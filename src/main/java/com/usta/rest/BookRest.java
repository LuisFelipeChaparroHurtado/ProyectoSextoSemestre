package com.usta.rest;

import com.usta.models.Author;
import com.usta.models.Book;
import com.usta.models.Loans;
import com.usta.service.AuthorService;
import com.usta.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book/")
public class BookRest {

    @Autowired
    private BookService bookService;


    @GetMapping("listBook")
    private ResponseEntity<List<Book>> listAllBook(){
        return ResponseEntity.ok(bookService.getAllBook());
    }

    @PostMapping("createBook")
    private ResponseEntity<Book> saveBook(@RequestBody Book book) {
        Book temporal = bookService.createBook(book);
        try{
            return ResponseEntity.created(new URI("/api/book/"+temporal.getIdBook())).body(book);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "searchBook/{id}")
    private ResponseEntity<Optional<Book>> listBookById(@PathVariable("id") Long id){
        return ResponseEntity.ok(bookService.findById(id));
    }

    @DeleteMapping("deleteBook/{id}")
    private ResponseEntity<String> deleteBook(@PathVariable("id") Long id){
        bookService.deleteBookById(id);
        return ResponseEntity.ok("Eliminado exitosamente");
    }

    @PutMapping("/updateBook")
    private ResponseEntity<Book> updateBook(@RequestBody Book book){
        Book temporal = bookService.createBook(book);
        try{
            return ResponseEntity.created(new URI("/api/book" + temporal.getIdBook())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/countBook")
    private ResponseEntity<String> listTotalBook(){
        return ResponseEntity.ok("El total de libros son: "+ String.valueOf(bookService.countTotalBook()));
    }

    @GetMapping(value = "searchPublisherIdBook/{id}")
    private ResponseEntity<String> searchPublisherByIdBook(@PathVariable("id") Long id){
        return ResponseEntity.ok(" NamePublisher: "+String.valueOf(bookService.searchPublisherByIdBook(id)));
    }
}
