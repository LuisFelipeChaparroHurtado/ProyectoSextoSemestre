package com.usta.repository;

import com.usta.models.Book;
import com.usta.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    @Query("SELECT count(publisher) FROM Publisher publisher")
    public Integer countTotalPublisher();
}
