package com.example.billingservice.feign;

import com.example.billingservice.model.Customer;
import com.example.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

    @GetMapping(path = "/customers/{id}")
    Customer getCustomerById(@PathVariable(name = "id") Integer id);

    @GetMapping(path = "/customers")
    PagedModel<Customer> getCustomers(@RequestParam(value = "page") int page, @RequestParam(value = "size") int size);

}
