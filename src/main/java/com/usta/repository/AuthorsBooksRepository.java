package com.usta.repository;

import com.usta.models.AuthorsBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorsBooksRepository extends JpaRepository<AuthorsBooks, Long> {
    @Query("SELECT count(authorsBooks) FROM AuthorsBooks authorsBooks")
    public Integer countTotalAuthorsBooks();
}
