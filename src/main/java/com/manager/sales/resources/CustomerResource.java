package com.manager.sales.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.sales.entities.Customer;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

    @GetMapping
    public ResponseEntity<Customer> findAll() {
        Customer u = new Customer(1L, "Fulano");
        return ResponseEntity.ok().body(u);
    }

}
