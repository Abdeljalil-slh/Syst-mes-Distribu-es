package com.example.billingservice.service;

import com.example.billingservice.model.Customer;
import com.example.billingservice.model.Product;
import com.example.billingservice.repository.CustomerRepository;
import com.example.billingservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class ConsumerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    @Bean
    Consumer<Customer> onAddingCustomerConsumer() {
        return (input) -> {
            System.out.println("***************************************");
            System.out.println(input.toString());
            System.out.println("***************************************");
            customerRepository.save(input);
        };
    }

    @Bean
    Consumer<Product> onAddingProductConsumer() {
        return (input) -> {
            System.out.println("***************************************");
            System.out.println(input.toString());
            System.out.println("***************************************");
            productRepository.save(input);
        };
    }


}
