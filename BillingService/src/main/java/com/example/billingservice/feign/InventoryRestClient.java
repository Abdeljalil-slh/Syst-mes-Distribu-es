package com.example.billingservice.feign;

import com.example.billingservice.model.Customer;
import com.example.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.QueryParam;
import java.util.List;

@FeignClient(name = "INVENTORY-SERVICE")
public interface InventoryRestClient {

    @GetMapping(path = "/products/{id}")
    Product getProductById(@PathVariable(name = "id") Integer id);

    @GetMapping(path = "/products")
    PagedModel<Product> getProducts(@RequestParam(value = "page") int page, @RequestParam(value = "size") int size);

}
