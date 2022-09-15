package com.usta.models;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Long idCustomer;

    @Column(name = "customer_identification")
    private String customerIdentification;

    @Column(name = "name_customer")
    private String nameCustomer;

    @Column(name = "surname_customer")
    private String surnameCustomer;

    @Column(name = "customer_address")
    private String customerAddress;

    @Column(name = "number_phone_customer")
    private String numberPhoneCustomer;

    public Customer(Long idCustomer, String customerIdentification, String nameCustomer, String surnameCustomer, String customerAddress, String numberPhoneCustomer) {
        this.idCustomer = idCustomer;
        this.customerIdentification = customerIdentification;
        this.nameCustomer = nameCustomer;
        this.surnameCustomer = surnameCustomer;
        this.customerAddress = customerAddress;
        this.numberPhoneCustomer = numberPhoneCustomer;
    }

    public Customer() {
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getCustomerIdentification() {
        return customerIdentification;
    }

    public void setCustomerIdentification(String customerIdentification) {
        this.customerIdentification = customerIdentification;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getSurnameCustomer() {
        return surnameCustomer;
    }

    public void setSurnameCustomer(String surnameCustomer) {
        this.surnameCustomer = surnameCustomer;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getNumberPhoneCustomer() {
        return numberPhoneCustomer;
    }

    public void setNumberPhoneCustomer(String numberPhoneCustomer) {
        this.numberPhoneCustomer = numberPhoneCustomer;
    }
}
