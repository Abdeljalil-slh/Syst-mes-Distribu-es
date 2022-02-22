package com.example.billingservice.web;

import com.example.billingservice.entity.Bill;
import com.example.billingservice.entity.ProductItem;
import com.example.billingservice.feign.CustomerRestClient;
import com.example.billingservice.feign.InventoryRestClient;
import com.example.billingservice.repository.BillRepository;
import com.example.billingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class BillingController {

    @Autowired private BillRepository billRepository;
    @Autowired private ProductItemRepository productItemRepository;
    @Autowired private InventoryRestClient inventoryRestClient;
    @Autowired private CustomerRestClient customerRestClient;

    @GetMapping(path = "/fullBill/{id}")
    public Bill getBill(@PathVariable Integer id) {
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerID()));
        for(ProductItem pi : bill.getProductItems()) {
            pi.setProduct(inventoryRestClient.getProductById(pi.getProductID()));
        }
        return bill;
    }

}
