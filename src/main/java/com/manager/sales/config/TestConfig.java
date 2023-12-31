package com.manager.sales.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.manager.sales.entities.Customer;
import com.manager.sales.repositories.CustomerRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        Customer u1 = new Customer(null, "Maria Brown");
        Customer u2 = new Customer(null, "Alex Green"); 

        customerRepository.saveAll(Arrays.asList(u1, u2));
    }

}
