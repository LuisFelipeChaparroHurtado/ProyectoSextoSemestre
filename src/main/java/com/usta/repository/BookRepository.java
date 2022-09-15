package com.usta.repository;

import com.usta.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT count(book) FROM Book book")
    public Integer countTotalBook();

    @Query("SELECT p.namePublisher " +
            "FROM Book b " +
            "INNER JOIN Publisher p " +
            "ON p.idPublisher = b.fkPublisher.idPublisher " +
            "WHERE b.idBook = :id")
    public String searchIdBook(Long id);

}
