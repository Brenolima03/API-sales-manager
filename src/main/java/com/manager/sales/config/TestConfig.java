package com.manager.sales.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.manager.sales.entities.Customer;
import com.manager.sales.entities.Order;
import com.manager.sales.entities.Payment;
import com.manager.sales.entities.Product;
import com.manager.sales.repositories.CustomerRepository;
import com.manager.sales.repositories.OrderRepository;
import com.manager.sales.repositories.PaymentRepository;
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

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public void run(String... args) throws Exception {
        Customer c1 = new Customer(null, "Maria Brown");
        // Customer c2 = new Customer(null, "Alex Green");

        Product p1 = new Product(null, "The Lord of the Rings", 90.5, 2);
        // Product p2 = new Product(null, "Smart TV", 2190.0, 3);
        // Product p3 = new Product(null, "Macbook Pro", 1250.0, 1);
        // Product p4 = new Product(null, "PC Gamer", 1200.0, 2);
        // Product p5 = new Product(null, "Rails for Dummies", 100.99, 3);

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), c1);
        // Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), c2);
        // Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), c1);

        customerRepository.saveAll(Arrays.asList(c1));
        productRepository.saveAll(Arrays.asList(p1));
        orderRepository.saveAll(Arrays.asList(o1));

        o1.getProducts().add(p1);
        // o2.getProducts().add(p3);
        // o3.getProducts().add(p2);

        orderRepository.saveAll(Arrays.asList(o1));

        // Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), 500.0, c1);
        // Payment pay2 = new Payment(null, Instant.parse("2019-07-23T10:30:00Z"), 800.0, c1);
        // Payment pay3 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), 450.0, c2);
        // Payment pay4 = new Payment(null, Instant.parse("2019-07-23T10:30:00Z"), 750.0, c2);

        // paymentRepository.saveAll(Arrays.asList(pay1, pay2, pay3, pay4));
    }

}