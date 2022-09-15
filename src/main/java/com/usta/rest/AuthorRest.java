package com.usta.rest;

import com.usta.models.Author;
import com.usta.models.Loans;
import com.usta.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/author/")
public class AuthorRest {

    @Autowired
    private AuthorService authorService;


    @GetMapping("listAuthor")
    private ResponseEntity<List<Author>> listAllAuthor(){
        return ResponseEntity.ok(authorService.getAllAuthor());
    }

    @PostMapping("createAuthor")
    private ResponseEntity<Author> saveAuthor(@RequestBody Author author) {
        Author temporal = authorService.createAuthor(author);
        try{
            return ResponseEntity.created(new URI("/api/author/"+temporal.getIdAuthor())).body(author);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "searchAuthor/{id}")
    private ResponseEntity<Optional<Author>> listAuthorById(@PathVariable("id") Long id){
        return ResponseEntity.ok(authorService.findById(id));
    }

    @DeleteMapping("deleteAuthor/{id}")
    private ResponseEntity<String> deleteAuthor(@PathVariable("id") Long id){
        authorService.deleteAuthorById(id);
        return ResponseEntity.ok("Eliminado exitosamente");
    }

    @PutMapping("/updateAuthor")
    private ResponseEntity<Author> updateAuthor(@RequestBody Author author){
        Author temporal = authorService.createAuthor(author);
        try{
            return ResponseEntity.created(new URI("/api/author" + temporal.getIdAuthor())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/countAuthor")
    private ResponseEntity<String> listTotalAuthor(){
        return ResponseEntity.ok("El total de autores son: "+ String.valueOf(authorService.countTotalAuthor()));
    }
}
