package com.usta.service;

import com.usta.models.Author;
import com.usta.models.Loans;
import com.usta.models.Publisher;
import com.usta.repository.AuthorRepository;
import com.usta.repository.LoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoansService {

    @Autowired
    private LoansRepository loansRepository;

    public List<Loans> getAllLoans(){
        return loansRepository.findAll();
    }

    public Loans createLoans(Loans loans){
        return loansRepository.save(loans);
    }

    public Optional<Loans> findById(Long id){
        return loansRepository.findById(id);
    }

    public void deleteLoansById(Long id){loansRepository.deleteById(id);}

    public Integer countTotalLoans(){return loansRepository.countTotalLoans();}

    public String searchCustomerByIdLoan(Long id){
        return loansRepository.searchIdCustomer(id);
    }
}
