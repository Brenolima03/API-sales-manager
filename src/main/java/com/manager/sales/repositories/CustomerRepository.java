package com.manager.sales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manager.sales.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}
