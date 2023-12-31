package com.manager.sales.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.sales.entities.Customer;
import com.manager.sales.repositories.CustomerRepository;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository repository;

    public List<Customer> findAll() {
        return repository.findAll();
    }

    public Customer findById(Long id) {
        Optional<Customer> obj = repository.findById(id);
        return obj.get();
    }
    
}
