package com.manager.sales.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.manager.sales.entities.Customer;
import com.manager.sales.repositories.CustomerRepository;
import com.manager.sales.services.exceptions.DatabaseException;
import com.manager.sales.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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

    public Customer insert(Customer obj) {
        return repository.save(obj);
    }

    public Customer update(Long id, Customer obj) {
		try {
			Customer entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}

    private void updateData(Customer entity, Customer obj) {
		entity.setName(obj.getName());
	}

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException  e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
    }

}
