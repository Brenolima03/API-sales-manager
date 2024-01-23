package com.manager.sales.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.manager.sales.entities.Payment;
import com.manager.sales.repositories.PaymentRepository;
import com.manager.sales.services.exceptions.DatabaseException;
import com.manager.sales.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    public List<Payment> findAll() {
        return repository.findAll();
    }

    public Payment findById(Long id) {
        Optional<Payment> obj = repository.findById(id);
        return obj.get();
    }

    public Payment insert(Payment obj) {
        return repository.save(obj);
    }

    public Payment update(Long id, Payment obj) {
		try {
			Payment entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}

    private void updateData(Payment entity, Payment obj) {
		entity.setDatetime(obj.getDatetime());
		entity.setValue(obj.getValue());
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
