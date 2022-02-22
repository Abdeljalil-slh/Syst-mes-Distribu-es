package com.example.billingservice.repository;

import com.example.billingservice.model.Customer;
import com.example.billingservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
