package com.example.billingsupplierservice.service;


import com.example.billingsupplierservice.model.Bill;
import com.example.billingsupplierservice.model.ProductItem;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Supplier;

@Service
public class BillingSupplierService {

    @Bean
    public Supplier<Bill> billSupplier(){
        return ()-> {
            List<ProductItem> products=new ArrayList<>();
            Bill bill=new Bill();

            bill.setBillDate(new Date());
            bill.setCustomerId(1L+new Random().nextInt(10));

                ProductItem productItem=new ProductItem();
                productItem.setBill(bill);
                productItem.setProductId(1L+new Random().nextInt(10));
                productItem.setQuantity(1+new Random().nextInt(10));
                productItem.setPrice(new Random().nextDouble(10));
                productItem.setDiscount(Math.random());

            ProductItem productItem1=new ProductItem();
            productItem1.setBill(bill);
            productItem1.setProductId( new Random().nextLong(10));
            productItem1.setQuantity(1+new Random().nextInt(10));
            productItem1.setPrice(new Random().nextDouble(10));
            productItem1.setDiscount(Math.random());

                products.add(productItem);
                products.add(productItem1);
            bill.setProductItems(products);
            return bill;
        };
        }

    }



