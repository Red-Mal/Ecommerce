package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Product.class);
            productRepository.saveAll(
                    List.of(
                         Product.builder().name("Computer").quantity(12).price(1200).build(),
                            Product.builder().name("Printer").quantity(32).price(120).build(),
                            Product.builder().name("Smartphone").quantity(31).price(900).build()
                    )
            );

            productRepository.save(new Product(null,"chair",788,200));
            productRepository.save(new Product(null,"drawer handle",8800,50));
            productRepository.save(new Product(null,"coasters",900,300));
            productRepository.save(new Product(null,"baking tray",1000,20));
            productRepository.save(new Product(null,"tape dispenser",950.50,50));
            productRepository.save(new Product(null,"cutlery",399,40));
            productRepository.save(new Product(null,"mirror",1500,200));
            productRepository.save(new Product(null,"salt & pepper shaker",1250.50,10));
            productRepository.save(new Product(null,"vase",899.99,400));
            productRepository.save(new Product(null,"desk lamp",88,500));
            productRepository.save(new Product(null,"lamp shade",7500,10));
            productRepository.save(new Product(null,"coffee mug",120,20));
            productRepository.save(new Product(null,"wall clock",1375.95,35));
            productRepository.save(new Product(null,"rocking chair",300.95,500));
            productRepository.save(new Product(null,"cable organizer",1200,250));
            productRepository.save(new Product(null,"road bike",4500.50,60));
        };
    }

}
