package com.usta.service;

import com.usta.models.Author;
import com.usta.models.Book;
import com.usta.models.Publisher;
import com.usta.repository.AuthorRepository;
import com.usta.repository.BookRepository;
import com.usta.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<Publisher> getAllPublisher(){
        return publisherRepository.findAll();
    }

    public Publisher createPublisher(Publisher publisher){
        return publisherRepository.save(publisher);
    }

    public Optional<Publisher> findById(Long id){
        return publisherRepository.findById(id);
    }

    public void deleteById(Long id){publisherRepository.deleteById(id);}

    public Integer countTotalPublisher(){return publisherRepository.countTotalPublisher();}

    //public Optional<Book> findPublisherBookById(Long id){
    //    return bookRepository.findById(id);
    //}
}
