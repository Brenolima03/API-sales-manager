package com.manager.sales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manager.sales.entities.Customer;

@Repository // This annotation is optional because this class already inherits it from the JpaRepository.
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
