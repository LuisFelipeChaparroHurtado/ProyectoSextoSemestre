package com.usta.service;

import com.usta.models.Author;
import com.usta.models.Publisher;
import com.usta.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthor(){
        return authorRepository.findAll();
    }

    public Author createAuthor(Author author){
        return authorRepository.save(author);
    }

    public Optional<Author> findById(Long id){
        return authorRepository.findById(id);
    }

    public void deleteAuthorById(Long id){authorRepository.deleteById(id);}

    public Integer countTotalAuthor(){return authorRepository.countTotalAuthor();}
}
