package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository,
                                               RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Customer.class);

            customerRepository.save(new Customer(null,"Jennifer","Whalen","7237 Wild Currant Way, Oakland, CA, 94611","JWhalen@gmail.com","650.507.9833"));
            customerRepository.save(new Customer(null,"Michael","Hartstein","3722 Kisling Loop, Tyndall Air Force Base, FL, 32403","MHartstein@gmail.com","650.507.9844"));
            customerRepository.save(new Customer(null,"Steven","King","1701 Foster Avenue, Panama City, FL, 32405","SKing@gmail.com","515.123.4567"));
            customerRepository.save(new Customer(null,"Alana","Walsh","3551 North Georgetown Drive, Montgomery, AL, 36109","AWalsh@gmail.com","650.507.9811"));
            customerRepository.save(new Customer(null,"Lisa","Ozer","102 Derondo Street, Panama City Beach, FL, 32413","LOzer@gmail.com","515.123.7777"));
            customerRepository.save(new Customer(null,"Harrison","Bloom","565 North Lakeshore Drive, Panama City Beach, FL, 32413","HBloom@gmail.com","515.123.8888"));
            customerRepository.save(new Customer(null,"William","Smith","7374 West Walden Drive, Littleton, CO, 80128","WSmith@gmail.com","515.123.4567"));
            customerRepository.save(new Customer(null,"Elizabeth","Bates","712 Parkside Place Northeast, Washington, DC, 20019","EBates@gmail.com","515.123.4568"));
            customerRepository.save(new Customer(null,"Alyssa","Hutton","1520 H Street Northwest, Washington, DC, 20006","AHutton@gmail.com","590.423.4568"));
            customerRepository.save(new Customer(null,"Jack","Livingston","74 Ranch Drive, Montgomery, AL, 36109","JLivingston@gmail.com","650.123.4234"));
            customerRepository.save(new Customer(null,"Kimberely","Grant","3109 Thistle Down Lane, Nashville, TN, 37013","KGrant@gmail.com","650.121.2004"));

            customerRepository.saveAll(
                    List.of(
                            Customer.builder()
                                    .lastName("Hassan")
                                    .email("hassan@gmail.com")
                                    .firstName("ELMALLAHI")
                                    .address("hay hassani")
                                    .phoneNumber("060000000")
                                    .build(),
                            Customer.builder()
                                    .lastName("Hanane")
                                    .email("hanane@gmail.com")
                                    .firstName("ELMALLAHI")
                                    .address("bournazil ")
                                    .phoneNumber("060000000")
                                    .build(),
                            Customer.builder()
                                    .lastName("Imane")
                                    .email("imane@gmail.com")
                                    .firstName("ELMALLAHI")
                                    .address("Maarif")
                                    .phoneNumber("060000000")
                                    .build()
                    )
            );
            customerRepository.findAll().forEach(c->{
                System.out.println(c);
            });

        };
    }

}
