package com.manager.sales.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.manager.sales.entities.Customer;
import com.manager.sales.entities.Order;
import com.manager.sales.repositories.CustomerRepository;
import com.manager.sales.repositories.OrderRepository;
import com.manager.sales.services.CustomerService;
import com.manager.sales.services.exceptions.ResourceNotFoundException;


@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

    @Autowired
    private CustomerService service;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public ResponseEntity<List<Customer>> findAll() {
        List<Customer> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id) {
        Customer obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Customer> insert(@RequestBody Customer obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping("/{customerId}/order/{orderId}")
    Customer bindOrderToCustomer(
        @PathVariable Long customerId,
        @PathVariable Long orderId
    ) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + customerId));
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + orderId));

        customer.getOrders().add(order);
        return customerRepository.save(customer);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
