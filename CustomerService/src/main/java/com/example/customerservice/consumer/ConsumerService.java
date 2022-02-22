package com.example.customerservice.consumer;

import com.example.customerservice.entity.Customer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class ConsumerService
{
    //@Bean
    public Consumer<Customer> customerConsumer() {
        return (input) -> {
            System.out.println("********************************");
            System.out.println("********************************");
            System.out.println(input);
            System.out.println("********************************");
            System.out.println("********************************");
        };
    }
}
