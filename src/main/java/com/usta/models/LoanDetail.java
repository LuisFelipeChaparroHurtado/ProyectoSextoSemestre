package com.usta.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "loan_detail")
public class LoanDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_loan_detail")
    private Long idLoanDetail;

    @Column(name = "return_date")
    private Date returnDate;

    @Column(name = "days_arrears")
    private Integer daysArrears;

    @Column(name = "description")
    private String description;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @JoinColumn(name = "fk_book", referencedColumnName = "id_book")
    @ManyToOne(fetch = FetchType.EAGER)
    private Book fkBook;

    @JoinColumn(name = "fk_loans", referencedColumnName = "id_loan")
    @ManyToOne(fetch = FetchType.EAGER)
    private Loans fkLoan;

    public LoanDetail(Long idLoanDetail, Date returnDate, Integer daysArrears, String description, Date deliveryDate, Book fkBook, Loans fkLoan) {
        this.idLoanDetail = idLoanDetail;
        this.returnDate = returnDate;
        this.daysArrears = daysArrears;
        this.description = description;
        this.deliveryDate = deliveryDate;
        this.fkBook = fkBook;
        this.fkLoan = fkLoan;
    }

    public LoanDetail() {
    }

    public Long getIdLoanDetail() {
        return idLoanDetail;
    }

    public void setIdLoanDetail(Long idLoanDetail) {
        this.idLoanDetail = idLoanDetail;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getDaysArrears() {
        return daysArrears;
    }

    public void setDaysArrears(Integer daysArrears) {
        this.daysArrears = daysArrears;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Book getFkBook() {
        return fkBook;
    }

    public void setFkBook(Book fkBook) {
        this.fkBook = fkBook;
    }

    public Loans getFkLoan() {
        return fkLoan;
    }

    public void setFkLoan(Loans fkLoan) {
        this.fkLoan = fkLoan;
    }
}
