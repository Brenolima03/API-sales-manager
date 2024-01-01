package com.manager.sales.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.manager.sales.entities.Customer;
import com.manager.sales.entities.Order;
import com.manager.sales.entities.Product;
import com.manager.sales.repositories.CustomerRepository;
import com.manager.sales.repositories.OrderRepository;
import com.manager.sales.repositories.ProductRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    
    @Autowired
    private CustomerRepository customerRepository;
        
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        Customer u1 = new Customer(null, "Maria Brown");
        Customer u2 = new Customer(null, "Alex Green");

        Product p1 = new Product(null, "The Lord of the Rings", 90.5, 12);
        Product p2 = new Product(null, "Smart TV", 2190.0, 18);
        Product p3 = new Product(null, "Macbook Pro", 1250.0, 10);
        Product p4 = new Product(null, "PC Gamer", 1200.0, 9);
        Product p5 = new Product(null, "Rails for Dummies", 100.99, 11);

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

        customerRepository.saveAll(Arrays.asList(u1, u2));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        o1.getProducts().add(p1);
        o2.getProducts().add(p3);
        o3.getProducts().add(p2);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }

}
