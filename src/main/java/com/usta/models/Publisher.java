package com.usta.models;

import javax.persistence.*;

@Entity
@Table(name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publisher")
    private Long idPublisher;

    @Column(name = "name_publisher")
    private String namePublisher;

    @Column(name = "country_publisher")
    private String countryPublisher;

    @Column(name = "number_phone_publisher")
    private String numberPhonePublisher;

    public Publisher(Long idPublisher, String namePublisher, String countryPublisher, String numberPhonePublisher) {
        this.idPublisher = idPublisher;
        this.namePublisher = namePublisher;
        this.countryPublisher = countryPublisher;
        this.numberPhonePublisher = numberPhonePublisher;
    }

    public Publisher() {
    }

    public Long getIdPublisher() {
        return idPublisher;
    }

    public void setIdPublisher(Long idPublisher) {
        this.idPublisher = idPublisher;
    }

    public String getNamePublisher() {
        return namePublisher;
    }

    public void setNamePublisher(String namePublisher) {
        this.namePublisher = namePublisher;
    }

    public String getCountryPublisher() {
        return countryPublisher;
    }

    public void setCountryPublisher(String countryPublisher) {
        this.countryPublisher = countryPublisher;
    }

    public String getNumberPhonePublisher() {
        return numberPhonePublisher;
    }

    public void setNumberPhonePublisher(String numberPhonePublisher) {
        this.numberPhonePublisher = numberPhonePublisher;
    }
}
