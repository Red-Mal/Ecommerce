package org.sid.billingservice.services;


import org.sid.billingservice.entities.Bill;
import org.sid.billingservice.repository.BillRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class BillingServiceConsumer {

    private BillRepository billRepository;

    public BillingServiceConsumer(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Bean
    public Consumer<Bill> billConsumer(){

        return (input)->{
          System.out.println("*****************");
          System.out.println(input.toString());
          billRepository.save(input);
          System.out.println("*****************");

        };
    }
}
