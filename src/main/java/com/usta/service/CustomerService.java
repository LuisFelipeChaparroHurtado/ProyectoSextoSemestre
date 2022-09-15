package com.usta.service;

import com.usta.models.Author;
import com.usta.models.Customer;
import com.usta.models.Publisher;
import com.usta.repository.AuthorRepository;
import com.usta.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public Customer createCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Optional<Customer> findById(Long id){
        return customerRepository.findById(id);
    }

    public void deleteCustomerById(Long id){customerRepository.deleteById(id);}

    public Integer countTotalCustomer(){return customerRepository.countTotalCustomer();}
}
