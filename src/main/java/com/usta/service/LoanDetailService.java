package com.usta.service;

import com.usta.models.Author;
import com.usta.models.LoanDetail;
import com.usta.models.Publisher;
import com.usta.repository.LoanDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanDetailService {

    @Autowired
    private LoanDetailRepository loanDetailRepository;

    public List<LoanDetail> getAllLoanDetail(){
        return loanDetailRepository.findAll();
    }

    public LoanDetail createLoanDetail(LoanDetail loanDetail){
        return loanDetailRepository.save(loanDetail);
    }

    public Optional<LoanDetail> findById(Long id){
        return loanDetailRepository.findById(id);
    }

    public void deleteLoanDetailById(Long id){loanDetailRepository.deleteById(id);}

    public Integer countTotalLoanDetail(){return loanDetailRepository.countTotalLoanDetail();}

    public String searchBookByIdLoanDetail(Long id){
        return loanDetailRepository.searchIdBook(id);
    }
}
