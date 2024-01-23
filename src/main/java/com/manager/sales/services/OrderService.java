package com.manager.sales.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.manager.sales.entities.Order;
import com.manager.sales.repositories.OrderRepository;
import com.manager.sales.services.exceptions.DatabaseException;
import com.manager.sales.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }

    public Order insert(Order obj) {
        return repository.save(obj);
    }

    public Order update(Long id, Order obj) {
		try {
			Order entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}

    private void updateData(Order entity, Order obj) {
        entity.setDatetime(obj.getDatetime());
        entity.setClient(obj.getClient());
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
