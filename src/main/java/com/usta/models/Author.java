package com.usta.models;

import javax.persistence.*;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_author")
    private Long idAuthor;

    @Column(name = "name_author")
    private String nameAuthor;

    @Column(name = "surname_author")
    private String surnameAuthor;

    @Column(name = "nationality_author")
    private String nationalityAuthor;

    @Column(name = "description_author")
    private String descriptionAuthor;

    public Author(Long idAuthor, String nameAuthor, String surnameAuthor, String nationalityAuthor, String descriptionAuthor) {
        this.idAuthor = idAuthor;
        this.nameAuthor = nameAuthor;
        this.surnameAuthor = surnameAuthor;
        this.nationalityAuthor = nationalityAuthor;
        this.descriptionAuthor = descriptionAuthor;
    }

    public Author() {
    }

    public Long getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Long idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getSurnameAuthor() {
        return surnameAuthor;
    }

    public void setSurnameAuthor(String surnameAuthor) {
        this.surnameAuthor = surnameAuthor;
    }

    public String getNationalityAuthor() {
        return nationalityAuthor;
    }

    public void setNationalityAuthor(String nationalityAuthor) {
        this.nationalityAuthor = nationalityAuthor;
    }

    public String getDescriptionAuthor() {
        return descriptionAuthor;
    }

    public void setDescriptionAuthor(String descriptionAuthor) {
        this.descriptionAuthor = descriptionAuthor;
    }
}
