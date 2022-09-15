package com.usta.service;

import com.usta.models.Author;
import com.usta.models.Book;
import com.usta.models.Publisher;
import com.usta.repository.AuthorRepository;
import com.usta.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    public Optional<Book> findById(Long id){
        return bookRepository.findById(id);
    }

    public void deleteBookById(Long id){bookRepository.deleteById(id);}

    public Integer countTotalBook(){return bookRepository.countTotalBook();}

    public String searchPublisherByIdBook(Long id){
        return bookRepository.searchIdBook(id);
    }
}
