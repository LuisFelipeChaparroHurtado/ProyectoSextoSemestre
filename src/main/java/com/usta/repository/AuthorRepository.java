package com.usta.repository;

import com.usta.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT count(author) FROM Author author")
    public Integer countTotalAuthor();

}
