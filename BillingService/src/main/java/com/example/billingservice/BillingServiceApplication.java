package com.example.billingservice;

import com.example.billingservice.entity.Bill;
import com.example.billingservice.entity.ProductItem;
import com.example.billingservice.feign.CustomerRestClient;
import com.example.billingservice.feign.InventoryRestClient;
import com.example.billingservice.model.Customer;
import com.example.billingservice.model.Product;
import com.example.billingservice.repository.BillRepository;
import com.example.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BillRepository billRepository,
                            ProductItemRepository productItemRepository,
                            CustomerRestClient customerRestClient,
                            InventoryRestClient inventoryRestClient) {
        return args -> {

            Customer c = customerRestClient.getCustomerById(1);
            Bill bill = billRepository.save(
                    new Bill(null, new Date(), null, c.getId(), null)
            );

            Product p = inventoryRestClient.getProductById(1);
            productItemRepository.save(
                    new ProductItem(null, p.getPrice(), 8, bill, p.getId(), null)
            );

            p = inventoryRestClient.getProductById(2);
            productItemRepository.save(
                    new ProductItem(null, p.getPrice(), 5, bill, p.getId(), null)
            );

            p = inventoryRestClient.getProductById(3);
            productItemRepository.save(
                    new ProductItem(null, p.getPrice(), 10, bill, p.getId(), null)
            );


        };
    }

}
