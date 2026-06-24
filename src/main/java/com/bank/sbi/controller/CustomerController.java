package com.bank.sbi.controller;

import com.bank.sbi.dto.CustomerDTO;
import com.bank.sbi.entity.Customer;
import com.bank.sbi.repository.CustomerRepository;
import com.bank.sbi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-service")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/customer")
    public ResponseEntity<?> createCustomer(@RequestBody CustomerDTO customerDTO){
        Customer customer = customerService.createCustomer(customerDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body("Customer created Successfully: "+customer);
    }
}
