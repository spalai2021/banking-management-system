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
import java.util.Optional;

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
        Optional<Customer> customer =  customerService.getCustomerByCustomerId(customerId);
        if (customer.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(customer);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Customer does not exist with customer id: "+customerId +": Please enter correct customer id");
    }

    @DeleteMapping("/customer/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("customerId") Long customerId) {
        Optional<Customer> customerExist = customerService.checkCustomerExist(customerId);
        if (customerExist.isPresent()) {
            customerService.deleteCustomer(customerId);
            return ResponseEntity.status(HttpStatus.OK).body("Customer deleted with customer id: " + customerId);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Customer does not exist with customer id: "+customerId +": Please enter correct customer id");
    }

    @PatchMapping("/customer/{customerId}")
    public ResponseEntity<?> UpdateCustomer(@PathVariable("customerId") Long customerId, @RequestBody CustomerDTO customerDTO) {
        Optional<Customer> customerExist = customerService.checkCustomerExist(customerId);
        if (customerExist.isPresent()) {
            Customer customer = customerService.updateCustomer(customerDTO);
            return ResponseEntity.status(HttpStatus.OK).body("Customer Updated with customer id: " + customerId + ":" + customer);
        }
        return ResponseEntity.status(HttpStatus.OK).body("Customer does not exist with customer id: " + customerId + ": Please enter correct customer id");
    }
}
