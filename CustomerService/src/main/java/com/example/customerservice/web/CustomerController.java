package com.example.customerservice.web;

import com.example.customerservice.entity.Customer;
import com.example.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private final String CUSTOMER_TOPIC = "CUSTOMER_TOPIC";

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private StreamBridge streamBridge;

    @PostMapping("/customers/add")
    public Customer addCustomer(@RequestBody Customer customer) {

        //ajouter dans ma bd
        Customer customerS = customerRepository.save(customer);

        //publication dans le topic
        streamBridge.send(CUSTOMER_TOPIC, customerS);

        return customerS;
    }

}
