package com.usta.rest;

import com.usta.models.Author;
import com.usta.models.AuthorsBooks;
import com.usta.models.Loans;
import com.usta.service.AuthorService;
import com.usta.service.AuthorsBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/authorsBooks/")
public class AuthorsBooksRest {

    @Autowired
    private AuthorsBooksService authorsBooksService;

    @GetMapping("listAuthorsBooks")
    private ResponseEntity<List<AuthorsBooks>> listAllAuthorBooks(){
        return ResponseEntity.ok(authorsBooksService.getAllAuthorsBooks());
    }

    @PostMapping("createAuthorsBooks")
    private ResponseEntity<AuthorsBooks> saveAuthorBooks(@RequestBody AuthorsBooks authorsBooks) {
        AuthorsBooks temporal = authorsBooksService.createAuthorsBooks(authorsBooks);
        try{
            return ResponseEntity.created(new URI("/api/authorsBooks/"+temporal.getIdAuthorsBooks())).body(authorsBooks);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "searchAuthorsBooks/{id}")
    private ResponseEntity<Optional<AuthorsBooks>> listAuthorsBooksById(@PathVariable("id") Long id){
        return ResponseEntity.ok(authorsBooksService.findById(id));
    }

    @DeleteMapping("deleteAuthorsBooks/{id}")
    private ResponseEntity<String> deleteAuthorsBooks(@PathVariable("id") Long id){
        authorsBooksService.deleteAuthorsBooksById(id);
        return ResponseEntity.ok("Eliminado exitosamente");
    }

    @PutMapping("/updateAuthorsBooks")
    private ResponseEntity<AuthorsBooks> updateAuthorsBooks(@RequestBody AuthorsBooks authorsBooks){
        AuthorsBooks temporal = authorsBooksService.createAuthorsBooks(authorsBooks);
        try{
            return ResponseEntity.created(new URI("/api/authorsBooks" + temporal.getIdAuthorsBooks())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/countAuthorsBooks")
    private ResponseEntity<String> listTotalAuthorsBooks(){
        return ResponseEntity.ok("El total de autores de libros son: "+ String.valueOf(authorsBooksService.countTotalAuthorsBooks()));
    }
}
