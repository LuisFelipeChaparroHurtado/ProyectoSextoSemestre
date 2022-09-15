package com.usta.models;

import javax.persistence.*;

@Entity
@Table(name = "authors_books")
public class AuthorsBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_authors_books")
    private Long idAuthorsBooks;

    @JoinColumn(name = "fk_book", referencedColumnName = "id_book")
    @ManyToOne(fetch = FetchType.EAGER)
    private Book fkBook;

    @JoinColumn(name = "fk_author", referencedColumnName = "id_author")
    @ManyToOne(fetch = FetchType.EAGER)
    private Author fkAuthor;

    public AuthorsBooks(Long idAuthorsBooks, Book fkBook, Author fkAuthor) {
        this.idAuthorsBooks = idAuthorsBooks;
        this.fkBook = fkBook;
        this.fkAuthor = fkAuthor;
    }

    public AuthorsBooks() {
    }

    public Long getIdAuthorsBooks() {
        return idAuthorsBooks;
    }

    public void setIdAuthorsBooks(Long idAuthorsBooks) {
        this.idAuthorsBooks = idAuthorsBooks;
    }

    public Book getFkBook() {
        return fkBook;
    }

    public void setFkBook(Book fkBook) {
        this.fkBook = fkBook;
    }

    public Author getFkAuthor() {
        return fkAuthor;
    }

    public void setFkAuthor(Author fkAuthor) {
        this.fkAuthor = fkAuthor;
    }
}
