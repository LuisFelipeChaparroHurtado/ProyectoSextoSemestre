package com.usta.rest;

import com.usta.models.Publisher;
import com.usta.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/publisher/")
public class PublisherRest {

    @Autowired
    private PublisherService publisherService;

    @GetMapping("listPublisher")
    private ResponseEntity<List<Publisher>> listAllPublisher(){
        return ResponseEntity.ok(publisherService.getAllPublisher());
    }

    @PostMapping("createPublisher")
    private ResponseEntity<Publisher> saveLoans(@RequestBody Publisher publisher) {
        Publisher temporal = publisherService.createPublisher(publisher);
        try{
            return ResponseEntity.created(new URI("/api/loans/"+temporal.getIdPublisher())).body(publisher);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "searchPublisher/{id}")
    private ResponseEntity<Optional<Publisher>> searchPublisherById(@PathVariable("id") Long id){
        return ResponseEntity.ok(publisherService.findById(id));
    }

    @DeleteMapping("deletePublisher/{id}")
    private ResponseEntity<String> deletePublisher(@PathVariable("id") Long id){
        publisherService.deleteById(id);
        return ResponseEntity.ok("Eliminado exitosamente");
    }

    @PutMapping("/updatePublisher")
    private ResponseEntity<Publisher> updatePublisher(@RequestBody Publisher publisher){
        Publisher temporal = publisherService.createPublisher(publisher);
        try{
            return ResponseEntity.created(new URI("/api/publisher" + temporal.getIdPublisher())).body(temporal);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/countPublisher")
    private ResponseEntity<String> listTotalPublisher(){
        return ResponseEntity.ok("El total de editoriales son: "+ String.valueOf(publisherService.countTotalPublisher()));
    }

    //@GetMapping(value = "searchPublisherBook/{id}")
    //private ResponseEntity<Optional<Publisher>> searchPublisherBookById(@PathVariable("id") Long id){
    //    return ResponseEntity.ok(publisherService.findPublisherBookById(id));
    //}
}
