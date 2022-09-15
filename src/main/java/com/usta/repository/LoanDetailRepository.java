package com.usta.repository;

import com.usta.models.LoanDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoanDetailRepository extends JpaRepository<LoanDetail, Long> {
    @Query("SELECT count(loanDetail) FROM LoanDetail loanDetail")
    public Integer countTotalLoanDetail();

    @Query("SELECT b.titleBook FROM LoanDetail ld INNER JOIN Book b ON ld.fkBook.idBook= b.idBook WHERE ld.idLoanDetail =:id")
    public String searchIdBook(Long id);
}
