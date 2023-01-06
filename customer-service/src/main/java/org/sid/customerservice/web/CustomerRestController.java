package org.sid.customerservice.web;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

    public CustomerRestController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    private final CustomerRepository customerRepository;
    Logger logger = LoggerFactory.getLogger(getClass());


    @GetMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<Customer>> getCustomers(){

        logger.info("[CustomerController] Get list of all Customers");
        List<Customer> customerList = customerRepository.findAll();

        if(customerList.isEmpty()) {
            logger.info("[CustomerController] List of Customer is empty");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }


    @PostMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {

        try{
            logger.info("[CustomerController] Add new customer");

            customerRepository.saveAndFlush(customer);
            return ResponseEntity.status(HttpStatus.CREATED).body("The customer has been successfully created");

        } catch (Exception e){
            logger.error("[CustomerController] Error while adding customer: {} ", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error occurred during the creation of the Customer");

        }
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        try {
            logger.info("get Customer by id");
            var customer = customerRepository.findById(id).get();

            return new ResponseEntity<>(customer, HttpStatus.OK);

        } catch (Exception e) {

            logger.error("Error during getting customer by id : {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") long id) {
        try {
            customerRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("[CustomerController] Error while deleting Customer: {} ", e.getMessage());
        }
    }
}

