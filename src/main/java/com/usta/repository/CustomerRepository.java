package com.usta.repository;

import com.usta.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT count(customer) FROM Customer customer")
    public Integer countTotalCustomer();
}
