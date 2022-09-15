package com.usta.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_book")
    private Long idBook;

    @Column(name = "title_book")
    private String titleBook;

    @Column(name = "date_publication")
    private Date datePublication;

    @Column(name = "code_book")
    private Integer codeBook;

    @Column(name = "isbn_book")
    private String isbnBook;

    @JoinColumn(name = "fk_publisher", referencedColumnName = "id_publisher")
    @ManyToOne(fetch = FetchType.EAGER)
    private Publisher fkPublisher;

    public Book(Long idBook, String titleBook, Date datePublication, Integer codeBook, String isbnBook, Publisher fkPublisher) {
        this.idBook = idBook;
        this.titleBook = titleBook;
        this.datePublication = datePublication;
        this.codeBook = codeBook;
        this.isbnBook = isbnBook;
        this.fkPublisher = fkPublisher;
    }

    public Book() {
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getTitleBook() {
        return titleBook;
    }

    public void setTitleBook(String titleBook) {
        this.titleBook = titleBook;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public Integer getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(Integer codeBook) {
        this.codeBook = codeBook;
    }

    public String getIsbnBook() {
        return isbnBook;
    }

    public void setIsbnBook(String isbnBook) {
        this.isbnBook = isbnBook;
    }

    public Publisher getFkPublisher() {
        return fkPublisher;
    }

    public void setFkPublisher(Publisher fkPublisher) {
        this.fkPublisher = fkPublisher;
    }
}
