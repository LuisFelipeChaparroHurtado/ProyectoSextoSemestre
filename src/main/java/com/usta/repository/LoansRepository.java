package com.usta.repository;

import com.usta.models.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoansRepository extends JpaRepository<Loans, Long> {
    @Query("SELECT count(loans) FROM Loans loans")
    public Integer countTotalLoans();

    @Query("SELECT c.nameCustomer, c.surnameCustomer FROM Loans l INNER JOIN Customer c ON l.fkCustomer.idCustomer= c.idCustomer WHERE l.idLoan =:id")
    public String searchIdCustomer(Long id);
}
