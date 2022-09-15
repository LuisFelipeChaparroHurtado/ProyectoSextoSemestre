package com.usta.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loans")
public class Loans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loan")
    private Long idLoan;

    @Column(name = "start_date_loan")
    private Date startDateLoan;

    @Column(name = "description")
    private String description;

    @JoinColumn(name = "fk_customer", referencedColumnName = "id_customer")
    @ManyToOne(fetch = FetchType.EAGER)
    private Customer fkCustomer;

    public Loans(Long idLoan, Date startDateLoan, String description, Customer fkCustomer) {
        this.idLoan = idLoan;
        this.startDateLoan = startDateLoan;
        this.description = description;
        this.fkCustomer = fkCustomer;
    }

    public Loans() {
    }

    public Long getIdLoan() {
        return idLoan;
    }

    public void setIdLoan(Long idLoan) {
        this.idLoan = idLoan;
    }

    public Date getStartDateLoan() {
        return startDateLoan;
    }

    public void setStartDateLoan(Date startDateLoan) {
        this.startDateLoan = startDateLoan;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Customer getFkCustomer() {
        return fkCustomer;
    }

    public void setFkCustomer(Customer fkCustomer) {
        this.fkCustomer = fkCustomer;
    }
}
