package com.usta.service;

import com.usta.models.Author;
import com.usta.models.AuthorsBooks;
import com.usta.models.Publisher;
import com.usta.repository.AuthorRepository;
import com.usta.repository.AuthorsBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorsBooksService {

    @Autowired
    private AuthorsBooksRepository authorsBooksRepository;

    public List<AuthorsBooks> getAllAuthorsBooks(){
        return authorsBooksRepository.findAll();
    }

    public AuthorsBooks createAuthorsBooks(AuthorsBooks authorsBooks){
        return authorsBooksRepository.save(authorsBooks);
    }

    public Optional<AuthorsBooks> findById(Long id){
        return authorsBooksRepository.findById(id);
    }

    public void deleteAuthorsBooksById(Long id){authorsBooksRepository.deleteById(id);}

    public Integer countTotalAuthorsBooks(){return authorsBooksRepository.countTotalAuthorsBooks();}
}
