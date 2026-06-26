package com.bank.sbi.controller;

import com.bank.sbi.dto.CustomerDTO;
import com.bank.sbi.entity.Customer;
import com.bank.sbi.repository.CustomerRepository;
import com.bank.sbi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/customers")
    public ResponseEntity<?> getAllCustomers(){
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.status(HttpStatus.OK).body(customers);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<?> getCustomerByCustomerId(@PathVariable("customerId") Long customerId){
        Customer customer =  customerService.getCustomerByCustomerId(customerId);
        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }

    @DeleteMapping("/customer/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("customerId") Long customerId) {
        customerService.checkCustomerExist(customerId);
        customerService.deleteCustomer(customerId);
        return ResponseEntity.status(HttpStatus.OK).body("Customer deleted with customer id: " + customerId);

    }

    @PatchMapping("/customer/{customerId}")
    public ResponseEntity<?> UpdateCustomer(@PathVariable("customerId") Long customerId, @RequestBody CustomerDTO customerDTO) {
        customerService.checkCustomerExist(customerId);
        Customer customer = customerService.updateCustomer(customerDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Customer Updated with customer id: " + customerId + ":" + customer);
}
}
